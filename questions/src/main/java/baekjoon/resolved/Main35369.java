package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main35369 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/35369
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken().trim());
        int[] arrival = new int[n];
        int[] departure = new int[m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), ":");
            int hour = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken().trim());
            arrival[i] = hour*3_600 + min*60 + sec;
        }
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), ":");
            int hour = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken().trim());
            departure[i] = hour*3_600 + min*60 + sec;
        }
        int spareSec = Integer.parseInt(br.readLine());
        //최소 환승 시간 계산
        int transferTime = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int diff = departure[j] - arrival[i];
                if(diff < 0) continue;

                if(diff >= spareSec && diff < transferTime) {
                    transferTime = diff;
                }
            }
        }
        System.out.println(transferTime == Integer.MAX_VALUE ? -1 : transferTime);
        br.close();
    }
}
