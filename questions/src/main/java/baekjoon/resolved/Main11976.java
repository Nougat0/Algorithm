package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main11976 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/11976
    */
    public static final int silver = 1;
    public static final int gold = 2;
    public static final int platinum = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] diff = new int[4];
        for(int i=0; i<4; i++) {
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            diff[i] = after - before;
        }
        //연산
        sb.append(diff[silver] + diff[gold] + diff[platinum]).append("\n");
        sb.append(diff[gold] + diff[platinum]).append("\n");
        sb.append(diff[platinum]).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
