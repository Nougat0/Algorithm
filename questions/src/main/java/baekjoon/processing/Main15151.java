package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main15151 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/15151
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int daysPassed = 0;
        int novels = 0;
        while(daysPassed < d) {
            daysPassed += (k *= 2);
            novels++;
        }
        System.out.println(novels);
        br.close();
    }
}
