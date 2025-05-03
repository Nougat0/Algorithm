package baekjoon.resolved;

import java.io.*;

public class Main11282 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/11282
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int i = Integer.parseInt(br.readLine());
        bw.write((char) (i + '가' - 1));
        bw.flush();
        bw.close();
        br.close();
    }
}
