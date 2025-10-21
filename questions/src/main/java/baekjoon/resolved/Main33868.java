package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main33868 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/33868
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int maxTime = 0;
        int minByte = 5001;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(t > maxTime) maxTime = t;
            if(b < minByte) minByte = b;
        }
        int number = maxTime*minByte % 7 + 1;
        System.out.println(number);
        br.close();
    }
}
