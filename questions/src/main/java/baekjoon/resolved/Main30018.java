package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main30018 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/30018
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer before, after;
        int n = Integer.parseInt(br.readLine());
        int plus = 0;

        before = new StringTokenizer(br.readLine());
        after = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int b = Integer.parseInt(before.nextToken());
            int a = Integer.parseInt(after.nextToken());
            int diff = a - b;
            if(diff > 0) plus += diff;
        }

        System.out.println(plus);
        br.close();
    }
}
