package baekjoon.resolved;

import java.io.*;

public class Main32651 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/32651
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n <= 100_000 && n % 2024 == 0) System.out.println("Yes");
        else System.out.println("No");

        br.close();
    }
}
