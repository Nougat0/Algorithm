package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main17264 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/17264
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int winPoints = Integer.parseInt(st.nextToken());
        int loosePoints = Integer.parseInt(st.nextToken());
        int neededPoints = Integer.parseInt(st.nextToken());
        int points = 0;

        //해킹한 플레이어 정보
        Map<String, Boolean> winnable = new HashMap<>();
        for(int i=0; i<p; i++) {
            st = new StringTokenizer(br.readLine());
            winnable.put(st.nextToken(), st.nextToken().charAt(0) == 'W');
        }
        //진행한 게임 정보 - ※ 승급 전까지만 게임 진행
        for(int i=0; i<n && points<neededPoints; i++) {
            Boolean result = winnable.getOrDefault(br.readLine(), false);
            if(result) {
                points += winPoints;
            } else {
                points = Math.max(0, points - loosePoints);
            }
        }
        //승급 판단
        if(points >= neededPoints) {
            System.out.println("I AM NOT IRONMAN!!");
        } else {
            System.out.println("I AM IRONMAN!!");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
