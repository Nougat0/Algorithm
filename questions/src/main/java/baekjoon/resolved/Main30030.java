package baekjoon.resolved;

import java.io.*;

public class Main30030 {
    /*
        https://www.acmicpc.net/problem/30030
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int b = Integer.parseInt(br.readLine());
        System.out.println(b / 11 * 10);
        br.close();
    }
}
