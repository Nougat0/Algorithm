package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main35409 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/35409
    */
    public static final int START = 0;
    public static final int END = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] submit = new int[][] {
                {transferToMinute(6,30), transferToMinute(9, 0)},
                {transferToMinute(9,50), transferToMinute(10, 0)},
                {transferToMinute(10,50), transferToMinute(11, 0)},
                {transferToMinute(11,50), transferToMinute(12, 0)},
                {transferToMinute(12,50), transferToMinute(13, 50)},
                {transferToMinute(14,40), transferToMinute(14, 50)},
                {transferToMinute(15,40), transferToMinute(15, 50)},
                {transferToMinute(16,40), transferToMinute(22, 50)},
        };

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int time = transferToMinute(h, m);
        int length = submit.length;
        boolean accepted = false;
        for(int i=0; i<length; i++) {
            if(time >= submit[i][START] && time <= submit[i][END]) {
                accepted = true;
                break;
            }
        }
        System.out.println(accepted ? "Yes" : "No");
        br.close();
    }

    public static int transferToMinute(int h, int m) {
        return h*60 + m;
    }
}
