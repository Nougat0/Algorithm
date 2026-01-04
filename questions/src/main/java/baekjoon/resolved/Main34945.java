package baekjoon.resolved;

import java.io.*;

public class Main34945 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34945
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(n >= 6 ? "Success!" : "Oh My God!");
        br.close();
    }
}
