package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main34073 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34073
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            if(i>0) sb.append(' ');
            sb.append(st.nextToken()).append("DORO");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
