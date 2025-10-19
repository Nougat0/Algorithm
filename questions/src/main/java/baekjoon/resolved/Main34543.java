package baekjoon.resolved;

import java.io.*;

public class Main34543 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34543
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int steps = Integer.parseInt(br.readLine());
        int score = n * 10;
        if(n >= 3) score += 20;
        if(n == 5) score += 50;
        if(steps > 1000) score -= 15;
        System.out.println(score >= 0 ? score : 0);
        br.close();
    }
}
