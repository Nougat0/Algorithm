package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main4697 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/4697
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n, w, l, h, m, area;
        double a;
        int ceiling, wall, windowAndDoor;
        while(true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            a = Double.parseDouble(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if(n == 0) break;
            ceiling = w * l;
            wall = h * (w + l) * 2;
            windowAndDoor = 0;

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                w = Integer.parseInt(st.nextToken());
                h = Integer.parseInt(st.nextToken());
                windowAndDoor += w * h;
            }
            area = (wall + ceiling - windowAndDoor) * n;
            sb.append(String.format("%.0f", Math.ceil(area / a))).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
