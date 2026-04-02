package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main30873 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/30873
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int x = 0;
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(Math.abs(p - x) <= c) x++;
        }
        System.out.println(x);
        br.close();
    }
}
