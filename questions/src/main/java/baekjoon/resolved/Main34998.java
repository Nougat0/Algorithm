package baekjoon.resolved;

import java.io.*;

public class Main34998 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34998
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            int count = Integer.parseInt(br.readLine());
            String line = br.readLine();
            int sum = getNumber(line.charAt(0));
            for(int j=1; j<=count; j++) {
                sum += getNumber(line.charAt(4 * j));
            }
            sb.append(sum > 9 ? "!" : sum).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getNumber(char c) {
        if(c == '!') return 10;
        else return c - '0';
    }
}
