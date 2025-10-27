package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main34236 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34236
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] years = new int[n];
        for(int i=0; i<n; i++) years[i] = Integer.parseInt(st.nextToken());

        System.out.println(years[n-1] + (years[1] - years[0]));
        br.close();
    }
}
