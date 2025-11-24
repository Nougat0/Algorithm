package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main15953 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/15953
    */
    static int[][] p2017 = new int[][] {{500, 1}, {300, 3}, {200, 6}, {50, 10}, {30, 15}, {10, 21}};
    static int[][] p2018 = new int[][] {{512, 1}, {256, 3}, {128, 7}, {64, 15}, {32, 31}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int prize = get2017Prize(a) + get2018Prize(b);
            sb.append(prize * 10_000).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int get2017Prize(int rank) {
        int prize = 0;
        if(rank <= 21)
            for(int i=0; i<6; i++)
                if(p2017[i][1] >= rank) {
                    prize = p2017[i][0];
                    break;
                }
        return prize;
    }

    private static int get2018Prize(int rank) {
        int prize = 0;
        if(rank <= 31)
            for(int i=0; i<5; i++)
                if(p2018[i][1] >= rank) {
                    prize = p2018[i][0];
                    break;
                }
        return prize;
    }
}
