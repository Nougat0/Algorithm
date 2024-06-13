package baekjoon.processing;

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
         * 다만 나눗셈이 있어서 0의 경우 확인
         * 0/n = 0 -> 오류 없음
         * n/0 = undefined -> 오류 발생 / 대체 출력문 없음...
         */

        bw.write(String.format("%d %d%n", (e*c - b*f)/(a*e - b*d), (c*d - a*f)/(b*d - a*e)));
//        bw.write(String.format("%d %d%n", (0)/(10), (c*d - a*f)/(b*d - a*e)));
        bw.flush();
        bw.close();
        br.close();
    }
}
