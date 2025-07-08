package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1934 {
    /*
        https://www.acmicpc.net/problem/1934
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int gcd = getGCD(a, b);
            int lcm = a * b / gcd;
            sb.append(lcm).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    /**
     * 최대공약수 구하는 유클리드 호제법 알고리즘
     * @param a
     * @param b
     * @return
     */
    public static int getGCD(int a, int b) {
        int remainder; //나머지
        while(a % b != 0) {
            remainder = a % b;
            a = b;
            b = remainder;
        }
        return b;
    }
}
