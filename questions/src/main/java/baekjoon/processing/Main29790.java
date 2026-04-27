package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main29790 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/29790
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        boolean baekjoonGosu = n >= 1000;
        boolean maplestoryGosu = u >= 8_000 || l >= 260;
        if(baekjoonGosu || maplestoryGosu) {
            if(baekjoonGosu && maplestoryGosu) {
                sb.append("Very ");
            }
            sb.append("Good");
        } else {
            sb.append("Bad");
        }
        System.out.println(sb);
        br.close();
    }
}