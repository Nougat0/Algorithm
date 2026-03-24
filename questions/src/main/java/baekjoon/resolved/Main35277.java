package baekjoon.resolved;

import java.io.*;

public class Main35277 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/35277
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = 900 + 60 + 600 + 170 + 160 + 110;
        int n = Integer.parseInt(br.readLine());
        System.out.println(n / price);
        br.close();
    }
}
