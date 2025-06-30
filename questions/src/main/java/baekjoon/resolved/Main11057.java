package baekjoon.resolved;

import java.io.*;

public class Main11057 {
    /*
        https://www.acmicpc.net/problem/11057
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final int MOD = 10_007;
        int[][] dp = new int[11][N+1];
        // 0~9인데 IndexOurOfBounds 예방 차원에서 1~10
        for(int number=1; number<=10; number++) {
            dp[number][1] = 1;
        }
        /* [dp값 구하기]
         * dp의 각 숫자란에 들어갈 값 = row 길이에서 각 숫자를 끝으로 가질 경우의 수
         * 예를 들어,
         *      1자릿수 -> 자기자신(1가지) -> 각 1
         *      2자릿수 ->  2의 경우 : 1자릿수에서 1, 2로 끝나는 경우 합산
         *                  3의 경우 : 1자릿수에서 1, 2, 3으로 끝나는 경우 합산
         *                  ...
         *      N자릿수 ->  M의 경우 : N-1 자릿수에서 1, 2,...,M-1, M으로 끝나는 경우 합산
         *
         * 한 발 더 나아가서, 같은 자릿수의 이전 숫자 값(누적 합산값) 재사용 가능
         *      N자릿수 -> M의 경우 : N-1 자릿수에서 M으로 끝나는 경우 + N 자릿수에서 M-1의 값
         */
        for(int index=2; index<=N; index++) {
            for(int number=1; number<=10; number++) {
                dp[number][index] = (dp[number][index-1] + dp[number-1][index]) % MOD;
            }
        }
        //합계 구하기 (여기서 n에 대한 연산 겸 합산 구하려다가 N=1일 때 오류나서 취소)
        int sum = 0;
        for(int number=1; number<=10; number++) {
            sum += dp[number][N];
        }
        System.out.println(sum % MOD);
        br.close();
    }
}
