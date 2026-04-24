package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main5235 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/5235
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            long even = 0, odd = 0;
            for(int j=0; j<k; j++) {
                int value = Integer.parseInt(st.nextToken());
                if(value % 2 == 0) even += value;
                else odd += value;
            }
            sb.append(odd == even ? "TIE" : (odd > even ? "ODD" : "EVEN")).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
