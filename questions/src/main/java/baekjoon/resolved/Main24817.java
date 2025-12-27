package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main24817 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/24817
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Map<String, Integer> index;
        int[] score;
        boolean[] winner;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        index = new HashMap<>();
        score = new int[n];
        winner = new boolean[n];
        int idx = 0;
        int winnerCount = 0;

        //선수 소개
        for(int i=0; i<n; i++) {
            index.put(br.readLine(), idx++);
        }

        //점수 기록
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int pIndex = index.get(name);
            int pScore = Integer.parseInt(st.nextToken());
            if(!winner[pIndex] && (score[pIndex] += pScore) >= p) {
                sb.append(name).append(" wins!\n");
                winner[pIndex] = true;
                winnerCount++;
            }
        }

        //출력
        if(winnerCount == 0) {
            sb.append("No winner!\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
