package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main8370 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/8370
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int k1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int k2 = Integer.parseInt(st.nextToken());
        System.out.println(n1*k1 + n2*k2);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
