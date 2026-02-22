package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main7130 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/7130
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int m, h, n, c, b;
        long sum = 0;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sum += Math.max(c * m, b * h);
        }
        System.out.println(sum);
        br.close();
    }
}
