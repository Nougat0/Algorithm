package baekjoon.resolved;

import java.io.*;

public class Main1904 {
    /*
        https://www.acmicpc.net/problem/1904
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final int mod = 15_746;
        int[] dp = new int[n+2];
        dp[1] = 1;
        dp[2] = 2;
        //DP 진행
        for(int length=3; length<=n; length++) {
            //00이 맨 앞에 오는 경우 + 1이 맨 앞에 오는 경우
            dp[length] = dp[length-1] % mod + dp[length-2] % mod;
        }
        System.out.println(dp[n] % mod);
        br.close();
    }
}
