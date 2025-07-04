package baekjoon.processing;

import java.io.*;

public class Main9625 {
    /*
        https://www.acmicpc.net/problem/9625
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int N = Integer.parseInt(br.readLine());
        final int A = 0;
        final int B = 1;
        int[][] dp = new int[2][N+1]; //A, B
        dp[A][0] = 1;
        int beforeB;
        for(int pushed=1; pushed<=N; pushed++) {
            beforeB = dp[B][pushed-1];
            dp[A][pushed] = beforeB;
            dp[B][pushed] = beforeB + dp[A][pushed-1];
        }
        sb.append(dp[A][N]).append(' ').append(dp[B][N]);
        System.out.println(sb);
        br.close();
    }
}
