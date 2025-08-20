package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main14724 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/14724
    */
    public static enum NAMES {
        PROBRAIN, GROW, ARGOS, ADMIN, ANT, MOTION, SPG, COMON, ALMIGHTY
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int count = NAMES.values().length;
        int value, max = 0, maxRow = -1;
        for(int row=0; row<count; row++) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                value = Integer.parseInt(st.nextToken());
                if(value > max) {
                    max = value;
                    maxRow = row;
                }
            }
        }
        bw.write(NAMES.values()[maxRow].name());
        bw.flush();
        bw.close();
        br.close();
    }
}
