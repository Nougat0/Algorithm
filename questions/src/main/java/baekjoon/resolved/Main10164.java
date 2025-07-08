package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main10164 {
    /*
        https://www.acmicpc.net/problem/10164
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][M+1];
        //맨 끝 1 미리 넣어주기
        for(int i=1; i<=N; i++) dp[i][1] = 1;
        for(int i=1; i<=M; i++) dp[1][i] = 1;
        //dp 채워넣기
        for(int row=2; row<=N; row++) {
            for(int col=2; col<=M; col++) {
                dp[row][col] = dp[row-1][col] + dp[row][col-1];
            }
        }
        if(K == 0) {
            System.out.println(dp[N][M]);
        } else {
            int kRow = (K-1) / M + 1;
            int kCol = (K-1) % M + 1;
            System.out.println(dp[kRow][kCol] * dp[N-kRow+1][M-kCol+1]);
        }
        br.close();
    }
}
