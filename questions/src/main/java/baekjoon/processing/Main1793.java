package baekjoon.processing;

import java.io.*;
import java.math.BigInteger;

public class Main1793 {
    /*
        https://www.acmicpc.net/problem/1793
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String input;
        while((input = br.readLine()) != null) {
            final int N = Integer.parseInt(input);
            BigInteger[] dp = new BigInteger[N+3]; //N이 0일 때도 감안
            dp[1] = BigInteger.ONE;
            dp[2] = BigInteger.valueOf(3);
            for(int i=3; i<=N; i++) {
                //11727번 문제랑 유사하나 임의 정밀도로 계산
                dp[i] = dp[i-1].add(dp[i-2].multiply(BigInteger.TWO));
            }
            sb.append(dp[N]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
