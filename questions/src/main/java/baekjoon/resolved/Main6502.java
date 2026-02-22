package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main6502 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/6502
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int pizza = 1;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            if(r == 0) break;
            int w = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            double d = Math.sqrt(w*w + l*l) / 2;
            sb.append("Pizza ").append(pizza).append(' ');
            if(d > r) sb.append("does not fit ");
            else sb.append("fits ");

            sb.append("on the table.\n");
            pizza++;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
