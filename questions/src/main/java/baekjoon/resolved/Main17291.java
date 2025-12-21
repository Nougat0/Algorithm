package baekjoon.resolved;

import java.io.*;

public class Main17291 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/17291
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] count = new int[n+1]; //N년 말에 존재하는 수
        int[] death = new int[n+5]; //N년에 분열 후 사망 수
        count[1] = 1;
        death[1+3] = 1;
        for(int y=2; y<=n; y++) {
            count[y] = count[y-1] * 2 - death[y];
            death[y+(y%2 == 0 ? 4 : 3)] += count[y-1];
        }
        System.out.println(count[n]);
        br.close();
    }
}
