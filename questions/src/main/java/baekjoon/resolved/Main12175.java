package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main12175 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/12175
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCases = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=testCases; testCase++) {
            st = new StringTokenizer(br.readLine());
            final int K = Integer.parseInt(st.nextToken()); //0~K
            final int V = Integer.parseInt(st.nextToken());
            //개수 세기
            boolean[][][] used = new boolean[K+1][K+1][K+1];
            //범위에 해당하는 경우의 수 세기
            int count = 0;
            for(int i=0; i<=K; i++) { //첫 자리 -- 최대값 최소값 지정됨
                //확인할 범위의 시작점에 대한 최소 최대값
                int min = i-V >= 0 ? i-V : 0;
                for(int start=min; start<=i; start++) {
                    //j, l 값 확인
                    int max = start+V <= K ? start+V : K;
                    for(int j=start; j<=max; j++) {
                        for(int l=start; l<=max; l++) {
                            if(!used[i][j][l]) {
                                count++;
                                used[i][j][l] = true;
                            }
                        }
                    }
                }
            }
            sb.append("Case #").append(testCase).append(": ").append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
