package baekjoon.resolved;

import java.io.*;

public class Main23731 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/23731
    */
    public final static int TEN = 10;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int length = number.length();
        long n = Long.parseLong(number);
        for(int i=1; i<=length; i++) {
            long digit = pow(TEN, i);
            long value = n % digit / pow(TEN, i-1);
            if(value >= 5) {
                n = (n / digit + 1) * digit;
            }
        }
        System.out.println(n);
        br.close();
    }

    //long 타입의 pow 함수 커스텀
    public static long pow(int base, int exponent) {
        long result = 1;
        for(int i=1; i<=exponent; i++) {
            result *= base;
        }
        return result;
    }
}
