package baekjoon.resolved;

import java.io.*;

public class Main13301 {
    /*
        https://www.acmicpc.net/problem/13301
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+2]; //정사각형 한 변의 길이 저장
        //미리 채워넣기
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        //둘레의 길이 (이번 길이, 이전 길이 사용)
        System.out.println((dp[N] * 2 + dp[N-1]) * 2);
        br.close();
    }
}
