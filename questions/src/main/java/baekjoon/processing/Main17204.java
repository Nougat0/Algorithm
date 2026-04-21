package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main17204 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/17204
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] point = new int[n];
        boolean recursive = false;
        for(int i=0; i<n; i++) {
            point[i] = Integer.parseInt(br.readLine());
            if(!recursive && point[i] == i) recursive = true;
        }

        int count = 0;
        int pointed = 0;
        while((pointed = point[pointed]) != 0) {
            count++;
            if(pointed == k) break;
            if(recursive && count > n) break;
        }

        if(pointed == k) {
            sb.append(count);
        } else {
            sb.append(-1); //pointed == 0 이거나 recursive 이거나
            // 재귀가 여러 개일수도 있으니 특정 int 값으로 한정짓지 않음
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
