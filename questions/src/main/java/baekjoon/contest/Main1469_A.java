package baekjoon.contest;

import java.io.*;
import java.util.StringTokenizer;

public class Main1469_A {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/contest/problem/1469/1
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int max = Math.max(x, y);
        int min = Math.min(x, y);

        for(int i=1; i<=max; i++) {
            if(i <= (max - min)) sb.append(1);
            else sb.append(2); //겹치는 부분
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
