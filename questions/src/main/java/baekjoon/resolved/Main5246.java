package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main5246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int boardCnt, pieceCnt;
        int[] rowCount;
        //보드별 정보
        boardCnt = Integer.parseInt(br.readLine());
        for(int i=0; i<boardCnt; i++) {
            rowCount = new int[8];
            st = new StringTokenizer(br.readLine());
            //보드 위 구조물 위치 정보
            pieceCnt = Integer.parseInt(st.nextToken());
            for(int j=0; j<pieceCnt; j++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                rowCount[y-1]++;
            }
            //가장 많은 구조물을 가진 줄 확인
            int maxLine = 0;
            for(int j=0; j<8; j++) {
                if(rowCount[j] > maxLine) maxLine = rowCount[j];
            }
            sb.append(maxLine).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
