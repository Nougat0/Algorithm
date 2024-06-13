package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //카드 n개 담기
        int[] cards = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            cards[i] = Integer.parseInt(st2.nextToken());
        }

        int max = 0;
        //가장 M에 가까운 max값 확인하기
        for(int i=0; i<n-2; i++) {
            for(int j=i+1; j<n-1; j++) {
                for(int k=j+1; k<n; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if(sum <= m && sum > max) {
                        max = sum;
                    }
                }
            }
        }
        bw.write(String.format("%d%n", max));
        bw.flush();
        bw.close();
        br.close();
    }
}
