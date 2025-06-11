package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main1010 {
    /*
        https://www.acmicpc.net/problem/1010
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        //DP 미리 진행
        int[][] dp = new int[30][30]; //Memoization
        //굳이 if문 쓰기 싫어서 미리 채워놓음
        for(int i=1; i<30; i++) {
            dp[1][i] = i; //1:N인 경우
            dp[i][i] = 1; //1:1인 경우
        }
        for(int w=2; w<30; w++) {
            for(int e=w+1; e<30; e++) {
                //서쪽 2: 3: ... 로 직접 경우별로 그려보고 깨달은 공식... (역시 막히면 그려봐야
                //맨 위 다리 연결할 때 아래의 경우는 이전에 계산해놓은 값을 사용해도 된다
                dp[w][e] = dp[w][e-1] + dp[w-1][e-1];
            }
        }

        int west, east;
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            west = Integer.parseInt(st.nextToken());
            east = Integer.parseInt(st.nextToken());
            sb.append(dp[west][east]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}