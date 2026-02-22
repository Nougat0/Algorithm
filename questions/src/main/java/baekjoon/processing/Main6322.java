package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main6322 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/6322
    */
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int num = 1, v = -1, not;
        int[] t;
        while(true) {
            st = new StringTokenizer(br.readLine());
            t = new int[3];
            not = -1;
            for(int i=0; i<3; i++) {
                t[i] = Integer.parseInt(st.nextToken());
                if(t[i] == -1) v = i;
                else if(not == -1) not = t[i];
            }
            if(t[a] == 0 && t[b] == 0 && t[c] == 0) break;
            if(num > 1) sb.append("\n\n");
            sb.append("Triangle #").append(num).append("\n");

            double side;
            if(v == c) {
                side = Math.sqrt(t[a]*t[a] + t[b]*t[b]);
            } else {
                side = Math.sqrt(t[c]*t[c] - not*not);
            }

            if(Double.isNaN(side)) {
                sb.append("Impossible.");
            } else {
                sb.append((char) (v + 'a')).append(" = ").append(String.format("%.3f", Math.floor(side * 1000) / 1000.0));
            }
            num++;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
