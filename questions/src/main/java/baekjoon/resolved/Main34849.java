package baekjoon.resolved;

import java.io.*;

public class Main34849 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34849
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long n2 = n * n;
        System.out.println(n2 <= 100_000_000 ? "Accepted" : "Time limit exceeded");
        br.close();
    }
}
