package baekjoon.resolved;

import java.io.*;

public class Main25372 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/25372
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String line;
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            line = br.readLine();
            int length = line.length();
            if(length >= 6 && length <= 9) sb.append("yes");
            else sb.append("no");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
