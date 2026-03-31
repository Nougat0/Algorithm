package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main35455 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/35455
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            if((10_000_000 + n) == s) {
                sb.append("Yes");
            } else {
                sb.append("No");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
