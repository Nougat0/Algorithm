package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main27035 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/27035
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] male = new int[n];
        int[] female = new int[n];
        for(int i=0; i<n; i++) {
            male[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<n; i++) {
            female[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(male);
        Arrays.sort(female);
        long sum = 0;
        for(int i=0; i<n; i++) {
            sum += Math.abs(male[i] - female[i]);
        }
        System.out.println(sum);
        br.close();
    }
}
