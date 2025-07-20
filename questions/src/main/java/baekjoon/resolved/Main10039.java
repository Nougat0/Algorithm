package baekjoon.resolved;

import java.io.*;

public class Main10039 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/10039
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0, score;
        for(int i=0; i<5; i++) {
            score = Integer.parseInt(br.readLine());
            sum += (score >= 40 ? score : 40);
        }
        System.out.println(sum / 5);
        br.close();
    }
}