package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main7510 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/7510
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        long value;
        long powSum=0;
        long max=0;
        for(int scenario=1; scenario<=n; scenario++, powSum=0, max=0) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                value = Integer.parseInt(st.nextToken());
                powSum += (value*value); //세 변의 제곱의 합
                if(value > max) max = value;
            }
            sb.append("Scenario #").append(scenario).append(":\n");
            if(powSum == max*max*2) { //직각 확인
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
            if(scenario < n) sb.append("\n");
        }
        //출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
