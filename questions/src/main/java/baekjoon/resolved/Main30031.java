package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main30031 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/30031
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int sum = 0;
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            sum += getPrice(Integer.parseInt(st.nextToken()));
        }
        System.out.println(sum);
        br.close();
    }

    public static int getPrice(int width) {
        switch(width) {
            case 136: return 1_000;
            case 142: return 5_000;
            case 148: return 10_000;
            default: return 50_000;
        }
    }
}
