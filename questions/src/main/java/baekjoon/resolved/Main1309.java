package baekjoon.resolved;

import java.io.*;

public class Main1309 {
    /*
        https://www.acmicpc.net/problem/1309
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //n번째 줄에 들어가는 가능한 경우들(총합)
        long[][] dp = new long[n][2]; // (left=right, none)
        final int mod = 9901;
        //첫 줄에 들어갈 수 있는 경우 초기값 left:1, right:1, none:1
        //다음 줄에 들어갈 수 있는 경우 left=right or none, right=left or none, none=left or right or none (반복)
        dp[0][0] = 1;
        dp[0][1] = 1;
        for(int i=1; i<n; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % mod; //left<->right에서 하나, none에서 하나
            dp[i][1] = (dp[i-1][0] * 2 + dp[i-1][1]) % mod; //none 은 left, right, none 모두에서 파생 가능
        }
        System.out.println((dp[n-1][0] * 2 + dp[n-1][1]) % mod); //left, right, none 모두 더한 값
        br.close();
    }
}
