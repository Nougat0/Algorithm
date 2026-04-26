package baekjoon.contest;

import java.io.*;
import java.util.*;

public class Main1675_A {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/contest/problem/1675/1
    */
    public static StringBuilder baekjoon;
    public static String STAR = "*";
    public static String BLANK = " ";
    public static String NEWLINE = "\n";
    public static void main(String[] args) throws IOException {
        /*
         ___*__*_*_
         __*__*___*
         _*___*___*
         *_____*_*_

         가장 넓은 구간 2=3+2, 3=5+2, 5=9+2
         2=(2*2-1), 3=(2*3-1), 5=(2*5-1)

        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        baekjoon = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int rows = 2*n;
        //int cols = (rows + 1) + (rows - 1) + 2;

        for(int i=0; i<rows; i++) {
            // "/" 먼저 그리기 (뒤 공백 세로선도 같이 그리기)
            draw(BLANK, rows-1-i);
            draw(STAR, 1);
            draw(BLANK, i+1);

            // "<>" 그리기
            int sum = rows-1;
            int outside = i>=n ? (n - 1 - (sum - i)) : (n - 1 - i);
            int inside = i>=n ? (2*(sum - i) + 1) : (2*i + 1);
            draw(BLANK, outside);
            draw(STAR, 1);
            draw(BLANK, inside);
            draw(STAR, 1);
            draw(BLANK, outside);
            draw(NEWLINE, 1);
        }

        bw.write(baekjoon.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    //loop 반복 공통코드로 뺌
    public static void draw(String icon, int length) {
        for(int j=0; j<length; j++) {
            baekjoon.append(icon);
        }
    }
}
