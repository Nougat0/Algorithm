package baekjoon.resolved;

import java.io.*;

public class Main26545 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/26545
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sum = 0;
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) sum += Integer.parseInt(br.readLine());
        System.out.println(sum);
        br.close();
    }
}
