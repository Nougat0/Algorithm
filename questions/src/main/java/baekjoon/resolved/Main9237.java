package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main9237 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/9237
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] growingDays = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            growingDays[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(growingDays); //오름차순 정렬 후 뒤에서부터 보기
        int maxTime = 0;
        for(int i=1; i<=n; i++) {
            if(growingDays[n-i] + i > maxTime) maxTime = growingDays[n-i] + i;
        }
        System.out.println(maxTime + 1);
        br.close();
    }
}
