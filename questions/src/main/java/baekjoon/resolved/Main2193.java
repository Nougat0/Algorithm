package baekjoon.resolved;

import java.io.*;

public class Main2193 {
    /*
        https://www.acmicpc.net/problem/2193
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        //배열 대신 직전값 저장변수만 사용
        long[][] dp = new long[n+1][2];
        dp[1][1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i][1] = dp[i-1][0];
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
        }
        System.out.println(dp[n][0] + dp[n][1]);
        br.close();
    }
}
