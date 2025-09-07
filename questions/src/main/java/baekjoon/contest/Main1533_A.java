package baekjoon.contest;

import java.io.*;
import java.util.*;

public class Main1533_A {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/contest/problem/1533/1
    */
    public static final String NO = "No";
    public static final String YES = "Yes";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ones = 0;
        int twos = 0;
        while(st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            if(number == 1) ones++;
            else twos++;
        }
        int sum = ones + twos*2;
        if(ones == 0) System.out.println(NO);
        else if(sum % 3 == 0) System.out.println(YES);
        else System.out.println(NO);

        br.close();
    }
}
