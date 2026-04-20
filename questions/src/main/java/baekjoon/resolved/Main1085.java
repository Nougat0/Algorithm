package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1085 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/1085
        https://www.acmicpc.net/source/79212634
        2024.06.04
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        //0~x || x~w || 0~y || y~h 중에서 작은 값 고르기
        int min = Math.min(Math.min((w-x), x), Math.min((h-y), y));
        bw.write(String.format("%d%n", min));
        bw.flush();
        bw.close();
        br.close();
    }
}
