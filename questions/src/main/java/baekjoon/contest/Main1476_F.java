package baekjoon.contest;

import java.io.*;
import java.util.StringTokenizer;

public class Main1476_F {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/contest/problem/1476/6
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        char[] coins = br.readLine().toCharArray();
        int count = 0;
        for(int i=0; i<n; i++) {
            if(coins[i] == 'D') count++;
        }
        sb.append(count);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
