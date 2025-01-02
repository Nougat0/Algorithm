package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main30143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        int piles, shortest, diff, cookies; //N, A, D, 답
        for(int i=0; i<testCase; i++) {
            st = new StringTokenizer(br.readLine());
            piles = Integer.parseInt(st.nextToken());
            shortest = Integer.parseInt(st.nextToken());
            diff = Integer.parseInt(st.nextToken());
            cookies = 0;

            int n = piles - 1;
            int diffCount = (n+1)*(n/2) + (n%2 == 0 ? 0 : n/2+1);
            cookies += shortest*piles; //기본높이 개수 취합
            cookies += diffCount*diff; //추가로 쌓이는 개수 취합
            sb.append(cookies).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
