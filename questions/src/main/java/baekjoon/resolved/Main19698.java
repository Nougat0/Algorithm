package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main19698 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/19698
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int rows = h/l;
        int cols = w/l;
        int total = rows * cols;
        System.out.println(n > total ? total : n);
        br.close();
    }
}
