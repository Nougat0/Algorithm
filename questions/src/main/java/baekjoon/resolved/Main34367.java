package baekjoon.resolved;

import java.io.*;

public class Main34367 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34367
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        while(n/10 > 0) {
            n = sumDigits(n);
        }
        System.out.println(n);
        br.close();
    }

    public static int sumDigits(long n) {
        int sum = 0;
        while(n/10 > 0) {
            sum += n % 10;
            n /= 10;
        }
        sum += n;
        return sum;
    }
}
