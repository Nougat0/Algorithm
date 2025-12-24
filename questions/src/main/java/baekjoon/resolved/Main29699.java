package baekjoon.resolved;

import java.io.*;

public class Main29699 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/29699
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = "WelcomeToSMUPC"; //14자
        int length = word.length();
        int n = Integer.parseInt(br.readLine());

        int number = n % length == 0 ? length : n % length;
        System.out.println(word.charAt(number - 1));
        br.close();
    }
}
