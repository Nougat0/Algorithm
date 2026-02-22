package baekjoon.resolved;

import java.io.*;

public class Main15000 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/15000
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        int length = line.length();
        char upper;
        for(int i=0; i<length; i++) {
            upper = (char) (line.charAt(i) - 'a' + 'A');
            sb.append(upper);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
