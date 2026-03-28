package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main23301 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/23301
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int min = 1000, max = 0;
        int[] sum = new int[1000];
        for(int i=0; i<n; i++) {
            int k = Integer.parseInt(br.readLine());
            for(int j=0; j<k; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                min = Math.min(start, min);
                max = Math.max(end, max);
                for(int l=start; l<end; l++) {
                    sum[l]++;
                }
            }
        }

        int sumByT = 0;
        int maxSum = 0;
        int start = 0, end = 0;
        for(int i=min; i<max && (i+t-1)<1000; i++) {
            //합계 구하기
            if(i == min) {
                for(int j=i; j<i+t; j++) {
                    sumByT += sum[j];
                }
            } else if(i > min) {
                sumByT -= sum[i-1];
                sumByT += sum[i+t-1];
            }

            //최대값 비교하기
            if(maxSum < sumByT) {
                maxSum = sumByT;
                start = i;
                end = i+t;
            }
        }
        sb.append(start).append(' ').append(end);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
