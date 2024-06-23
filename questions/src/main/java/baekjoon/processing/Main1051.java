package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] square = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                square[i][j] = Character.getNumericValue(row[j]);
            }
        }
        //출력
        bw.write(checkSquare(square)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 가장 큰 정사각형 찾기 (찾다가 정 안되면 1개짜리도 정사각형 정답 취급)
     * @return 존재하지 않을 경우 1
     */
    public static int checkSquare(int[][] square) {
        int maxDiff = 0;
        int count = 1;
        for(int i=0; i<square.length - 1 - maxDiff; i++) {
            for(int j=0; j<square[0].length - 1 - maxDiff; j++) {
                //왼쪽 상단 꼭지점(i,j)에서 사각형 확인
                for(int k=j+1+maxDiff; k<square[0].length; k++) {
                    System.out.println("반복문 실행" + count++);
                    if(square[i][j] == square[i][k]) {
                        int diff = k-j;
                        if(i+diff > square.length - 1 || maxDiff >= diff) continue;
                        if(square[i][j] == square[i+diff][j] && square[i][j] == square[i+diff][k]) {
                            maxDiff = diff;
                        }
                    }
                }
            }
        }
        if(maxDiff == 0) return 1;
        else return (int) Math.pow(maxDiff+1, 2);
    }
}
