package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main30993 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/30993
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long result = f(n) / (f(a) * f(b) * f(c));
        System.out.println(result);
        br.close();
    }

    public static long f(long n) {
        if(n == 1)  return 1;
        return n * f(n-1);
    }
}
