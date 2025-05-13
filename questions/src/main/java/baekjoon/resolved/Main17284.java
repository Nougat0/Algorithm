package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main17284 {
    /*
        https://www.acmicpc.net/problem/17284
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] price = new int[] {500, 800, 1000};
        int cash = 5000;
        int category;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            category = Integer.parseInt(st.nextToken()) - 1;
            cash -= price[category];
        }
        System.out.println(cash);
        br.close();
    }
}
