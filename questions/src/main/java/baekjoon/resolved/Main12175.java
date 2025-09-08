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
            //범위에 해당하는 경우의 수 세기
            int count = 0;
            for(int i=0; i<=K; i++) { //첫 자리 -- 최대값 최소값 지정됨
                //확인할 범위의 시작점에 대한 최소 최대값
                int min = i-V >= 0 ? i-V : 0;
                int maxLoop = Math.min(K-V, i);
                for(int start=min; start<=maxLoop; start++) {
                    if(start == min) count += Math.pow(V+1, 2); //처음에는 온전한 네모
                    else count += (V*2 + 1); //끝에 꺾인 한줄
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
