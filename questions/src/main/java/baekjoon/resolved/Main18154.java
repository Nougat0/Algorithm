package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main18154 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/18154
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        double maxSpeed = 0.0;
        //초기값 0, 0
        st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());
        //이후 측정
        for(int i=1; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            double speed = (double) (d - distance)/(t-time);
            maxSpeed = Math.max(speed, maxSpeed);
            time = t;
            distance = d;
        }
        System.out.printf("%d%n",(int) maxSpeed);
        br.close();
    }
}
