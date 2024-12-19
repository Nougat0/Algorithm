package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main5246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int boardCnt, pieceCnt;
        boolean[][] board;
        //보드별 정보
        boardCnt = Integer.parseInt(br.readLine());
        for(int i=0; i<boardCnt; i++) {
            board = new boolean[8][8];
            st = new StringTokenizer(br.readLine());
            //보드 위 구조물 위치 정보
            pieceCnt = Integer.parseInt(st.nextToken());
            for(int j=0; j<pieceCnt; j++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[y-1][x-1] = true;
            }
            //가장 많은 구조물을 가진 줄 확인
            int maxLine = 0;
            for(int j=0; j<8; j++) {
                int vertical = 0;
                int horizontal = 0;
                for(int k=0; k<8; k++) {
                    if(board[j][k]) horizontal++;
                    if(board[k][j]) vertical++;
                }
                if(horizontal > maxLine) maxLine = horizontal;
                if(vertical > maxLine) maxLine = vertical;
            }
            sb.append(maxLine).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
