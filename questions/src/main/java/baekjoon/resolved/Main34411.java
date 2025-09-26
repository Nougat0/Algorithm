package baekjoon.resolved;

import java.io.*;

public class Main34411 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34411
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        System.out.println(m*n);
        br.close();
    }
}
