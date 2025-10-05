package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main14409 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/14409
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final int N = Integer.parseInt(br.readLine());
        final int X = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            if(Math.abs(p1 - p2) <= X) {
                sum += Math.max(p1, p2);
            } else {
                sum += Integer.parseInt(br.readLine());
            }
        }
        System.out.println(sum);
        br.close();
    }
}
