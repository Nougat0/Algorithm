package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main11170 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/11170
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = 0;
            for(int i=n; i<=m; i++) {
                count += getZeroCount(i);
            }
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int getZeroCount(int number) {
        int count = 0;
        while(number / 10 > 0) {
            if(number % 10 == 0) count++;
            number /= 10;
        }
        if(number == 0) count++; // number 최초값이 0일 때
        return count;
    }
}
