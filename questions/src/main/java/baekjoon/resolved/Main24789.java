package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main24789 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/24789
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        if((x*2 + y) % 2 == 1) {
            sb.append("im");
        }
        sb.append("possible");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
