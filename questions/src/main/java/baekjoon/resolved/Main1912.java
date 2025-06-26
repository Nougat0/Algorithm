package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1912 {
    /*
        https://www.acmicpc.net/problem/1912
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] maxAt = new int[n+1];
        //Kadane's 알고리즘 사용함
        /*
            수열: a: [a1, a2, a3, a4]
            dp[1] = max(a1)
            dp[2] = max(a1+a2, a2)
            dp[3] = max(a1+a2+a3, a2+a3, a3)
                  = max(max(a1+a2, a2)+a3, a3)
                  = max(dp[2]+a3, a3)
            dp[n] = max(dp[n-1]+a[n], a[n])
        */
        int value, maxValue = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++) {
            value = Integer.parseInt(st.nextToken());
            maxAt[i] = Math.max(maxAt[i-1] + value, value);
            maxValue = Math.max(maxValue, maxAt[i]);
        }
        System.out.println(maxValue);
        br.close();
    }
}
