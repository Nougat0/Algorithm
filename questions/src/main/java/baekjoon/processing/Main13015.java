package baekjoon.processing;

import java.io.*;

public class Main13015 {
    public static final String star = "*";
    public static final String blank = " ";
    // >< 이런 모양 만들기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        //2: 2+1+2, 5: 5+7+5
        int maxX = 4*n-3;
        int maxY = 2*n-1;
        boolean[][] x = new boolean[2*n-1][4*n-3];
        //당장 생각나는 것은 각 변 그리기? 변은 모두 같은 길이니까
        //1. 밑/윗 변 그리기
        for(int i=0; i<n; i++) {
            x[0][i] = true;
            x[maxY-1][i] = true;
            x[0][maxX-1-i] = true;
            x[maxY-1][maxX-1-i] = true;
        }
//        //2. 왼쪽 위에서 오른쪽 아래로
//        for(int i=0; i<n; i++) {
//            x[i][i] = true;
//            x[(n-1)+i][maxX-1-(n-1)+i] = true;
//        }
//        //3. 오른쪽 위에서 왼쪽 아래로
//        for(int i=0; i<n; i++) {
//            x[i][maxX-1-i] = true;
//            x[(n-1)+i][(n-1)+i] = true;
//        }
        //양쪽 비교연산자 그리기
        //>
        for(int i=1; i<maxY/2; i++) //정방향
            x[i][i] = true;
        for(int i=maxY/2; i<maxY-1; i++) //역방향
            x[i][maxY-i-1] = true;
        for(int i=1; i<maxY/2; i++) //정방향
            x[i][i+maxY/2] = true;
        for(int i=maxY/2; i<maxY-1; i++) //역방향
            x[i][maxY-i-1+maxY/2] = true;
        //<
        for(int i=1; i<maxY/2; i++) //역방향
            x[i][maxX-1-i] = true;
        for(int i=maxY/2; i<maxY-1; i++) //정방향
            x[i][maxX-n+i-maxY/2] = true;
        for(int i=1; i<maxY/2; i++) //역방향
            x[i][maxX-1-i-maxY/2] = true;
        for(int i=maxY/2; i<maxY-1; i++) //정방향
            x[i][maxX-n+i-maxY/2-maxY/2] = true;

        //출력
        for(int i=0; i<maxY; i++) {
            for(int j=0; j<maxX; j++)
                bw.write(x[i][j] ? star : blank);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
