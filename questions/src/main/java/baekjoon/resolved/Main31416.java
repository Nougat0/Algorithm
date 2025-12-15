package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main31416 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/31416
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int testCase=0; testCase<n; testCase++) {
            st = new StringTokenizer(br.readLine());
            int ta = Integer.parseInt(st.nextToken());
            int tb = Integer.parseInt(st.nextToken());
            int va = Integer.parseInt(st.nextToken());
            int vb = Integer.parseInt(st.nextToken());

            int aFinish;
            int bFinish;
            int minTime = 20_001;
            //도훈의 도움 X (0개) ~ 도움 MAX (va개) 확인
            for(int help=0; help<=va; help++) {
                aFinish = ta * (va - help);
                bFinish = tb * vb + ta * help;
                minTime = Math.min(Math.max(aFinish, bFinish), minTime);
            }
            sb.append(minTime).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
