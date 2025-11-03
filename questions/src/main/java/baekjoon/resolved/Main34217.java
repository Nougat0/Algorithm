package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main34217 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34217
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] time = new int[2];
        for(int i=0; i<2; i++) {
            st = new StringTokenizer(br.readLine());
            time[0] += Integer.parseInt(st.nextToken());
            time[1] += Integer.parseInt(st.nextToken());
        }

        if(time[0] > time[1]) System.out.println("Yongdap");
        else if(time[0] < time[1]) System.out.println("Hanyang Univ.");
        else System.out.println("Either");
        br.close();
    }
}
