package baekjoon.resolved;

import java.io.*;
import java.util.*;
public class Main19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        /**
         * Brute Force가 아닌 방식
         * ax + by = c
         * dx + ey = f
         *
         * adx + bdy = cd
         * adx + aey = af
         *
         * cd - bdy = af - aey
         * cd - af = bdy - aey
         * -------------------------
         * aex + eby = ec
         * bdx + eby = bf
         *
         * ec - aex = bf - bdx
         * (cd - af)/(bd - ae) = y (정수) %값이 0
         * (ec - bf)/(ae - bd) = x (정수) %값이 0
         * -------------------------
         * -1,000,000 < a*b < 1,000,000 (int 범위 충족)
         */
        //bw.write(String.format("%d %d%n", (e*c - b*f)/(a*e - b*d), (c*d - a*f)/(b*d - a*e)));

        /**
         * Brute Force 방식으로 풀기
         */
        outerLoop:
        for(int i=-999; i<1000; i++) {
            for(int j=-999; j<1000; j++){
                if((a*i + b*j == c) && (d*i + e*j == f)) {
                    bw.write(String.format("%d %d%n", i, j));
                    break outerLoop;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
