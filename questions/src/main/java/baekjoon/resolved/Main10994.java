package baekjoon.resolved;

import java.io.*;

public class Main10994 {
    public static final String star = "*";
    public static final String blank = " ";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int layer = Integer.parseInt(br.readLine());
        int side = 4*layer-3;
        boolean[][] square = new boolean[side][side];

        //재귀로 사각형 그리기
        drawSquare(square, layer, layer);

        //출력
        for(int i=0; i<side; i++) {
            for(int j=0; j<side; j++)
                bw.write(square[i][j] ? star : blank);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 
     * @param square 사각형을 그릴 배열
     * @param totalLayers 사각형의 총 layer 개수
     * @param layer 현재 그려야 할 사각형 layer 번호
     */
    private static void drawSquare(boolean[][] square, int totalLayers, int layer) {
        if(layer == 0) return;
        int side = 4*layer - 3; //한 변의 길이
        int start = 2*(totalLayers-layer); //왼쪽 위 꼭지점(시작점)
        for(int i=start; i<start+side; i++) 
            for(int j=start; j<start+side; j++) 
                if(i==start || i==start+side-1 || j==start || j==start+side-1)
                    square[i][j] = true;
        drawSquare(square, totalLayers, layer-1);
    }
}
