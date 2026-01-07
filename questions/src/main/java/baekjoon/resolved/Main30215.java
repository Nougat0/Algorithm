package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main30215 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/30215
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int drO = Integer.parseInt(st.nextToken());
        int alyssa = Integer.parseInt(st.nextToken());
        int konari = Integer.parseInt(st.nextToken());
        int max = Math.max(drO / konari, drO / alyssa);

        int exist = 0;
        for(int i=1; i<=max; i++) {
            if((drO - alyssa * i > 0) && (drO - alyssa * i) % konari == 0) {
                exist++;
                break;
            }
        }
        System.out.println(exist);
        br.close();
    }
}
