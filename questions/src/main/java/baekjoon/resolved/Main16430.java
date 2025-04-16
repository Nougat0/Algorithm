package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main16430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int remains = b-a;
        int gcd = getGCD(remains, b);
        bw.write(remains/gcd + " " + b/gcd);
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 최대공약수 구하기
     * @param a
     * @param b
     * @return
     */
    public static int getGCD(int a, int b) {
        int remainder;
        while(a % b != 0) {
            remainder = a % b;
            a = b;
            b = remainder;
        }
        return b;
    }
}
