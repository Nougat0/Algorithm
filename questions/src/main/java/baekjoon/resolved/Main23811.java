package baekjoon.resolved;

import java.io.*;

public class Main23811 {
    /*
        https://www.acmicpc.net/problem/23811
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        int length = 5*k;
        for(int row=0; row<length; row++) {
            for(int col=0; col<length; col++) {
                if(col/k == 0 || row/k == 0 || row/k == 2 || row/k == 4) sb.append('@');
                else break;
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
