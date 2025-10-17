package baekjoon.resolved;

import java.io.*;

public class Main34509 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34509
    */
    public static void main(String[] args) throws IOException {
        int number = -1;
        for(int i=10; i<=99; i++) {
            int tens = i/10;
            int ones = i%10;

            if((tens != 8 && ones != 8) && ((tens + ones) % 6 == 0) && ((ones*10 + tens) % 4 == 0)) {
                number = i;
                break;
            }
        }
        System.out.println(number);
    }
}
