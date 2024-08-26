package baekjoon.resolved;

import java.io.*;

public class Main2447 {
    public static final String star = "*";
    public static final String blank = " ";
    /**
     * 0 ~ n/3-1 // n/3 ~ n/3*2-1 // n/3*2 ~ n-1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        boolean[][] square = new boolean[n][n]; //true: blank, false: star

        //재귀함수로 구멍 뚫기
        punchHoles(square, 0, 0, n);

        //결과 출력
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++)
                bw.write(square[i][j] ? blank : star);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 전달받은 square 배열을 9개의 정사각형 칸을 가진 것으로 간주하고,
     * 정 가운데 칸만 뚫고 나머지 칸은 다시 pinchHoles 재귀호출을 함
     * 최종적으로 cellSize 3까지만 구멍 뚫기 진행
     * @param square 구멍을 뚫을 배열
     * @param xStart 현재 칸의 x 시작값
     * @param yStart 현재 칸의 y 시작값
     * @param cellSize 현재 칸의 크기
     */
    private static void punchHoles(boolean[][] square, int xStart, int yStart, int cellSize) {
        if(cellSize == 1) return;
        int nextCellSize = cellSize/3;
        // 3*3 = 9개 칸으로 생각
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                if(i==1 && j==1) {
                    //정가운데 칸: 구멍뚫기
                    for(int k=xStart+nextCellSize; k<xStart+nextCellSize*2; k++)
                        for(int l=yStart+nextCellSize; l<yStart+nextCellSize*2; l++)
                            square[k][l] = true;
                } else {
                    //그 외 칸: 재귀함수 실행
                    punchHoles(square,xStart+nextCellSize*i, yStart+nextCellSize*j, nextCellSize);
                }
    }
}
