package baekjoon.resolved;

import java.io.*;

public class Main11726 {
    /*
        https://www.acmicpc.net/problem/11726
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = 10_007;
        int n = Integer.parseInt(br.readLine());
        int[] cases = new int[n+2];
        cases[1] = 1; //세운 경우 하나
        cases[2] = 2; //세운 경우 하나, 누운 경우 하나
        //DP 연산
        for(int length=3; length<=n; length++) {
            //이번 경우의 수 = 맨 앞이 세로 블럭일 경우 + 누운 블럭일 경우
            cases[length] = cases[length - 1] % MOD + cases[length - 2] % MOD;
        }
        System.out.println(cases[n] % MOD);
        br.close();
    }
}
