package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main23968 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/23968
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());

        /** 버블 정렬 - 의사 코드
         * bubble_sort(A[0..N-1]) { # A[0..N-1]을 오름차순 정렬한다.
         *     for last <- N-1 downto 1
         *         for i <- 0 to last - 1
         *             if (A[i] > A[i + 1]) then A[i] <-> A[i + 1]  # 원소 교환
         * }
         */
        int temp, count = 0;
        kIsFound:
        for(int last=n-1; last>=1; last--) {
            for(int i=0; i<=last-1; i++) {
                if(a[i] > a[i+1]) {
                    temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    count++;
                }
                if(count == k) {
                    sb.append(a[i]).append(' ').append(a[i+1]);
                    break kIsFound;
                }
            }
        }
        if(count < k) sb.append(-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
