package baekjoon.resolved;

import java.io.*;

public class Main27541 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/27541
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        if(s.charAt(n-1) == 'G') {
            sb.append(s.substring(0, n-1));
        } else {
            sb.append(s).append('G');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
