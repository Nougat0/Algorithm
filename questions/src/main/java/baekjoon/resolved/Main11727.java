package baekjoon.resolved;

import java.io.*;

public class Main11727 {
    /*
        https://www.acmicpc.net/problem/11727
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final int MOD = 10_007;
        int[] dp = new int[N+2];
        dp[1] = 1;
        dp[2] = 3;
        for(int i=3; i<=N; i++) {
            //이번 경우의 수 =
            //  맨 앞이 세로 1개인 경우의 수 +
            //  맨 앞이 누운 2개, 정사각 1개인 경우의 수 (서로 같으므로 *2)
            //맨 앞 블럭의 크기 지정 후, 남은 뒷 자리에서 타일 정렬하는 경우의 수 찾기
            //뒷 자리 길이 -> 해당 길이일 때의 dp값 가져오기
            dp[i] = (dp[i-1]%MOD + dp[i-2]%MOD * 2)%MOD;
        }
        System.out.println(dp[N]);
        br.close();
    }
}
