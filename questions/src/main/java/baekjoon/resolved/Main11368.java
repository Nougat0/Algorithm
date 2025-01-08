package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main11368 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        long c, w, l, p;
        while(true) {
            st = new StringTokenizer(br.readLine());
            c = Long.parseLong(st.nextToken());
            w = Long.parseLong(st.nextToken()); // w/l
            l = Long.parseLong(st.nextToken()); // l/p
            p = Long.parseLong(st.nextToken()); // p/b
            if(c == 0 && w == 0 && l == 0 && p == 0) {
                break;
            }
            sb.append(String.format("%.0f",Math.pow(c, w*l*p))).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
