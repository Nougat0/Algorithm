package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main15876 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/15876
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder line = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        //문자열 만들기
        int number = 0;
        while(line.length() <= (K + N*4)) {
            line.append(Integer.toBinaryString(number++));
        }
        //출력하기
        for(int i=0; i<5; i++) {
            sb.append(line.charAt(K + N*i - 1)).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
