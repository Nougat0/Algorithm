package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main28066 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/28066
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> que = new ArrayDeque<>();
        for(int i=1; i<=n; i++) {
            que.add(i);
        }
        int first = 0;
        while(que.size() > 1) {
            first = que.poll();
            for(int i=1; i<k; i++) {
                que.poll();
            }
            que.add(first);
        }
        System.out.println(first);
        br.close();
    }
}
