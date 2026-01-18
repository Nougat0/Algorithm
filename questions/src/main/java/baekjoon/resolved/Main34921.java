package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main34921 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34921
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int p = 10 + 2 * (25 - a + t);
        System.out.println(Math.max(0, p));
        br.close();
    }
}
