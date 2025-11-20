package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main31833 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/31833
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        for(int i=1; i<n; i++) x = addOnto(x, Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        long y = Integer.parseInt(st.nextToken());
        for(int i=1; i<n; i++) y = addOnto(y, Integer.parseInt(st.nextToken()));

        bw.write(Math.min(x, y) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static long addOnto(long addedNum, int num) {
        int multiply = num/10 > 0 ? 100 : 10;
        return addedNum * multiply + num;
    }
}
