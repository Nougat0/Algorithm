package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main9184 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][][] result = new int[101][101][101];
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1 && c == -1) break;
            sb.append(w(a, b, c)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * Top-Down 방식 DP
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int w(int a, int b, int c) {
        int newA = a+50, newB = b+50, newC = c+50; //배열용 조정값
        if(result[newA][newB][newC] != 0) { //DP 추가
            return result[newA][newB][newC];
        } else { //w 함수 (문제 제시)
            int calc;
            if(a <= 0 || b <= 0 || c <= 0) calc = 1;
            else if(a > 20 || b > 20 || c > 20) calc = w(20, 20, 20);
            else if(a < b && b < c) calc = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
            else calc = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
            return (result[newA][newB][newC] = calc);
        }
    }
}