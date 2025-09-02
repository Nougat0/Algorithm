package baekjoon.resolved;

import java.io.*;

public class Main2998 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2998
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String binary = br.readLine();
        int length = binary.length();
        int repeat = length % 3 > 0 ? 3 - (length % 3) : 0;
        binary = "0".repeat(repeat) + binary;
        length += repeat;

        for(int i=0; i<length/3; i++) {
            int number = 0;
            number += (binary.charAt(i*3) - '0') * 4;
            number += (binary.charAt(i*3+1) - '0') * 2;
            number += (binary.charAt(i*3+2) - '0') * 1;
            sb.append(number);
        }
        System.out.println(sb);
        br.close();
    }
}
