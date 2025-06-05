package baekjoon.processing;

import java.io.*;

public class Main23805 {
    /*
        https://www.acmicpc.net/problem/23805
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
                if(col/k % 2 == 0 || (row/k == 0 && col/k == 1) || (row/k == 4 && col/k == 3)) sb.append('@');
                else sb.append(' ');
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
