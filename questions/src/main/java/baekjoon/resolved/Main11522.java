package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main11522 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/11522
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int p = Integer.parseInt(br.readLine());
        while(p-- > 0) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int sum1 = n * (n+1) / 2; //1~N 까지의 합
            int sum2 = n * (n+1) - n; //홀수 N개의 합
            int sum3 = n * (n+1); //짝수 N개의 합
            sb.append(k).append(' ')
                .append(sum1).append(' ')
                .append(sum2).append(' ')
                .append(sum3).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
