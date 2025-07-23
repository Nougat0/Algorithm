package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main32841 {
    /*
        https://www.acmicpc.net/problem/32841
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int R = Integer.parseInt(st.nextToken());
        final int C = Integer.parseInt(st.nextToken());
        String input;
        for(int row=1, asymmetric=0; row<=R; row++) {
            input = br.readLine();
            int length = input.length();
            int left = (C - length)/2;
            int right = left;
            if((C - length) % 2 != 0) { //불균형 빈 공간 존재 시
                asymmetric++;
                if(asymmetric % 2 == 0) left++;
                else right++;
            }
            sb.append(".".repeat(left)).append(input).append(".".repeat(right)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
