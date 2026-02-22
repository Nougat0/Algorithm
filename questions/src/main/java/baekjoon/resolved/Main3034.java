package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main3034 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/3034
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        double d2 = Math.sqrt(w*w + h*h);
        while(n-- > 0) {
            int l = Integer.parseInt(br.readLine());
            if(l > d2) sb.append("NE");
            else sb.append("DA");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
