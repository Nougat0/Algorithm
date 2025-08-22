package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1871 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/1871
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), "-");
            int former = change26RadixTo10(st.nextToken());
            int latter = Integer.parseInt(st.nextToken());
            sb.append(Math.abs(former - latter) <= 100 ? "nice" : "not nice").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int change26RadixTo10(String number) {
        int sum = 0;
        int length = number.length();
        for(int i=0; i<length; i++) {
            int num = number.charAt(i) - 'A';
            sum += num * (long) Math.pow(26, length - 1 - i);
        }
        return sum;
    }
}
