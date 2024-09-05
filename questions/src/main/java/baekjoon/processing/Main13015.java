package baekjoon.processing;

import java.io.*;

public class Main13015 {
    public static final String star = "*";
    public static final String blank = " ";
    public static final String newLine = "\n";
    // >><< 모양 만들기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        //2: 2+1+2, 5: 5+7+5
        int maxX = 4*n-3;
        int maxY = 2*n-1;
        boolean[][] x = new boolean[maxY][maxX];
        //1. 밑/윗 변 그리기
        for(int i=0; i<n; i++) {
            x[0][i] = true;
            x[maxY-1][i] = true;
            x[0][maxX-1-i] = true;
            x[maxY-1][maxX-1-i] = true;
        }
        //>
        drawGreaterThan(x, 0, 1, maxY);
        drawGreaterThan(x, maxY/2, 1, maxY);
        //<
        drawLessThan(x,0,1, maxX, maxY, n);
        drawLessThan(x,maxY/2,1, maxX, maxY, n);

        //출력
        for(int i=0; i<maxY; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<maxX; j++)
                sb.append(x[i][j] ? star : blank);
            //오른쪽 빈칸 모두 제거하기 (right-trim)
            bw.write(sb.toString().replaceAll("\\s+$",""));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    /** > 모양 그리기 **/
    public static void drawGreaterThan(boolean[][] x, int startX, int startY, int maxY) {
        for(int currY=startY; currY<maxY/2; currY++) //정방향
            x[currY][currY+startX] = true;
        for(int currY=maxY/2;  currY<maxY-1; currY++) //역방향
            x[currY][maxY-1+startX-currY] = true;
    }
    /** < 모양 그리기 **/
    public static void drawLessThan(boolean[][] x, int startX, int startY, int maxX, int maxY, int n) {
        for(int currY=startY; currY<maxY/2; currY++) //역방향
            x[currY][maxX-1-currY-startX] = true;
        for(int currY=maxY/2; currY<maxY-1; currY++) //정방향
            x[currY][maxX-n+currY-maxY/2-startX] = true;
    }
}
