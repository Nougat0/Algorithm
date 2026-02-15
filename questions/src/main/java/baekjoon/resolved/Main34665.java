package baekjoon.resolved;

import java.io.*;

public class Main34665 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34665
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        System.out.println(a.equals(b) ? 0 : 1550);
        br.close();
    }
}
