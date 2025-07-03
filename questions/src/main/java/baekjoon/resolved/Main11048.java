package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main11048 {
    /*
        https://www.acmicpc.net/problem/11048
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][M+1]; //최대값 관리
        int candy = 0;
        //첫 줄은 왼쪽만 합산
        st = new StringTokenizer(br.readLine());
        for(int col=1; col<=M; col++) {
            dp[1][col] = dp[1][col-1] + Integer.parseInt(st.nextToken());
        }
        //N번째 줄은 왼쪽, 위쪽, 왼쪽 대각선 중 최대값 합산
        for(int row=2; row<=N; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=1; col<=M; col++) {
                dp[row][col] = Math.max(Math.max(dp[row][col-1], dp[row-1][col]), dp[row-1][col-1]) + Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dp[N][M]);
        br.close();
    }
}
