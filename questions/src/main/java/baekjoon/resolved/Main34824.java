package baekjoon.resolved;

import java.io.*;

public class Main34824 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34824
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        boolean yonseiWon = false;
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            if(s.equals("yonsei")) {
                yonseiWon = true;
                break;
            } else if(s.equals("korea")) {
                break;
            }
        }
        sb.append("Yonsei ");
        if(yonseiWon) sb.append("Won!");
        else sb.append("Lost...");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
