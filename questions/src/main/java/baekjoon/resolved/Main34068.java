package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main34068 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34068
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] winCount = new int[n+1];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int winner = Integer.parseInt(st.nextToken());
            //int loser = Integer.parseInt(st.nextToken());
            winCount[winner]++;
        }
        //점수 나열하기
        int maxScore = Math.max(n, m);
        int[] score = new int[maxScore+1];
        for(int i=1; i<=n; i++) {
            score[winCount[i]]++;
        }
        //2명 이상 있는 점수대에서 결투하기
        long neededRounds = 0;
        for(int i=0; i<=maxScore; i++) {
            int scoreCount = score[i];
            //n명이면 점수별로 1명씩 고르게 폈을 때 0~(n-1)점
            //0점에 20만명 있는 경우 long 범위의 경기횟수가 필요할 수 있음
            //토너먼트가 아니라서 중복경기가 가능...하지만 그래도 최대점수 한계는 존재
            if(scoreCount > 1) {
                int rounds = scoreCount-1;
                score[i+1] += rounds;
                neededRounds += rounds;
            }
        }
        bw.write(neededRounds + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
