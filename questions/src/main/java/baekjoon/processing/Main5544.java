package baekjoon.processing;

import java.io.*;
import java.util.*;
public class Main5544 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/5544
    */

    public static int[] sorted; //정렬 결과 저장용 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int games = n*(n-1)/2;
        int[] score = new int[n]; //점수 기록용
        int[] rank = new int[n]; //순위 기록용
        Integer[] ordered = new Integer[n]; //index 정렬용 배열
        for(int i=0; i<n; i++) ordered[i] = i;
        //입력
        while(games-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1; //index 보정
            int b = Integer.parseInt(st.nextToken()) - 1; //index 보정
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            //경기 결과
            if(c == d) { //무승부
                score[a] += 1;
                score[b] += 1;
            } else if(c > d){ //a팀 승리
                score[a] += 3;
            } else if(c < d) { //b팀 승리
                score[b] += 3;
            }
        }
        //점수 순서대로 index 정렬
        Arrays.sort(ordered, Comparator.comparingInt(i -> score[(int) i]).reversed());
        int beforeScore, currentRank = 1;
        for(int i=0, sameRank=1; i<n; i++, sameRank=1) {
            beforeScore = score[ordered[i]];
            rank[ordered[i]] = currentRank;
            while(i+1 < n && score[ordered[i+1]] == beforeScore) {
                rank[ordered[i++ +1]] = currentRank;
                sameRank++;
            }
            currentRank += sameRank; //같은 등수 가진 팀 수 추가 (다음 등수)
        }
        //출력
        for(int i=0; i<n; i++) {
            sb.append(rank[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
