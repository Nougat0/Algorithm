package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main21623 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/21623
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int moves = Integer.parseInt(st.nextToken());
        int initial = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        /* 예외처리
        If the last move of the game had ended the round, Petya didn't not begin a new round and his score was 0.
        */
        int score = initial;
        int round = 0;
        while(st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            if(score >= number) {
                score -= number;
                if(score == 0) {
                    round++;
                    if(st.hasMoreTokens()) score = initial;
                }
            }
        }
        sb.append(round).append("\n").append(score);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
