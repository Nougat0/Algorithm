package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main17390 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/17390
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int min = 1_001;
        int[] count = new int[min];
        st = new StringTokenizer(br.readLine());
        //입력과 동시에 배열 정렬 사용
        for(int i=0; i<n; i++) {
            int number = Integer.parseInt(st.nextToken());
            min = Math.min(min, number);
            count[number]++;
        }
        //누적합 구하기
        int[] sum = new int[n+1];
        int idx = 1, num = min;
        while(idx < n+1) {
            //빈 공간 건너뛰기
            while(count[num] == 0) num++;
            //개수만큼 반복해서 채우기
            int c = count[num];
            for(int i=1; i<=c; i++) {
                sum[idx] = sum[idx-1] + num;
                idx++;
            }
            num++;
        }
        //Q개의 줄에 걸쳐 출력
        while(q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(sum[r] - sum[l-1]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
