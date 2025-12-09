package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main34802 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34802
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String woken = br.readLine();
        String start = br.readLine();
        int diff = getDiffSeconds(woken, start);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(t / 100 * (100 - k) <= diff) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        br.close();
    }

    private static int[] getTime(String t) {
        return new int[] {
            (t.charAt(0) - '0') * 10 + (t.charAt(1) - '0'),
            (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0'),
            (t.charAt(6) - '0') * 10 + (t.charAt(7) - '0'),
        };
    }

    private static int getDiffSeconds(String w, String s) {
        final int HOUR = 0;
        final int MIN = 1;
        final int SEC = 2;

        int[] woken = getTime(w);
        int[] start = getTime(s);

        int wokenTime = woken[HOUR] * 3600 + woken[MIN] * 60 + woken[SEC];
        int startTime = start[HOUR] * 3600 + start[MIN] * 60 + start[SEC];

        return startTime - wokenTime;
    }
}
