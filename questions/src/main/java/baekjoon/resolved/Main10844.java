package baekjoon.resolved;

import java.io.*;

public class Main10844 {
    /*
        https://www.acmicpc.net/problem/10844
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final int MOD = 1_000_000_000;
        int[][] dp = new int[10][N+1];
        //미리 채워넣기
        for(int number=1; number<=9; number++) {
            dp[number][1] = 1;
        }
        //DP 연산
        // 길이 2에서 1로 끝나는 건 앞자리 3밖에 없지만
        // 앞자리 0값이 0이므로 점화식 사용해도 무방함
        for(int length=2; length<=N; length++) {
            for(int number=1; number<=8; number++) {
                dp[number][length] = (dp[number-1][length-1] + dp[number+1][length-1]) % MOD;
            }
            dp[9][length] = dp[8][length-1];
            dp[0][length] = dp[1][length-1];
        }
        //합산
        long sum = 0;
        for(int number=0; number<=9; number++) {
            sum = (sum + dp[number][N]) % MOD;
        }
        System.out.println(sum % MOD);
        br.close();
    }
}
