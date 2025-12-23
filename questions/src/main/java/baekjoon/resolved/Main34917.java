package baekjoon.resolved;

import java.io.*;

public class Main34917 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34917
    */
    public static final char INK = '#';
    public static final char BLANK = '.';
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testCases = Integer.parseInt(br.readLine());
        for(int t=0; t<testCases; t++) {
            int n = Integer.parseInt(br.readLine());
            printM_onBanner(n, sb);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void printM_onBanner(int n, StringBuilder banner) {
        for(int r=0; r<n; r++) {
            banner.append(INK);
            if(r == 0 || r > n/2) {
                for(int c=1; c<n-1; c++) banner.append(BLANK);
            } else {
                for(int c=1; c<n-1; c++) {
                    boolean isInk = c == r || n-1-c == r;
                    banner.append(isInk ? INK : BLANK);
                }
            }
            banner.append(INK).append("\n");
        }
    }
}
