package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main3412 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/3412
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCases = Integer.parseInt(br.readLine());
        while(testCases-- > 0) {
            int score = 0;
            int n = Integer.parseInt(br.readLine());
            while(n-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                double distanceFromCenter = Math.sqrt(x * x + y * y);
                int circle = (int) (distanceFromCenter / 20) + (distanceFromCenter % 20 > 0 ? 1 : 0);
                //Bull's Eye 예외처리
                if(circle == 0) {
                    circle = 1;
                }
                //점수 계산하기
                if(circle <= 10) {
                    score += (11 - circle);
                }
            }
            sb.append(score).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
