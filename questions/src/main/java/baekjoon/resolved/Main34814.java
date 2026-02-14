package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main34814 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34814
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n + 1];
        int like, hate;
        st = new StringTokenizer(br.readLine());
        for(int d=1; d<=n; d++) {
            a[d] = Integer.parseInt(st.nextToken());
        }

        for(int p=0; p<m; p++) {
            st = new StringTokenizer(br.readLine());
            like = Integer.parseInt(st.nextToken());
            hate = Integer.parseInt(st.nextToken());
            if(a[hate] < getMax(a)) {
                a[like]--;
            }
        }

        for(int d=1; d<=n; d++) {
            sb.append(a[d]).append(' ');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getMax(int[] a) {
        int max = 0;
        for(int i : a) {
            if(max < i) max = i;
        }
        return max;
    }
}
