package baekjoon.resolved;

import java.io.*;

public class Main26529 {
    /*
        https://www.acmicpc.net/problem/26529
        https://www.acmicpc.net/user/bcdlife
    */
    public static long[] bunnies = new long[46];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        //n 최대값까지 미리 전개
        bunnies[0] = 1;
        bunnies[1] = 1;
        for(int i=2; i<=45; i++) {
            bunnies[i] = bunnies[i-1] + bunnies[i-2];
        }
        int month;
        while(n-- > 0) {
            month = Integer.parseInt(br.readLine());
            sb.append(bunnies[month]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
