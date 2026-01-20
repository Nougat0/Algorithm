package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main34922 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34922
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        double safeZone = w * h - Math.PI * n * n / 4;
        bw.write(String.format("%.3f", safeZone));
        bw.flush();
        bw.close();
        br.close();
    }
}
