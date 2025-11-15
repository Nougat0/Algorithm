package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main24610 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/24610
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int capacity = Integer.parseInt(st.nextToken());
        int schools = Integer.parseInt(st.nextToken());
        int[] registered = new int[schools];
        int max = 0;
        for(int s=0; s<schools; s++) {
            int teams = Integer.parseInt(br.readLine());
            registered[s] = teams;
            max = Math.max(max, teams);
        }
        //팀 배정
        int[] accepted = new int[schools];
        int totalTeams = 0;
        int wave = 1;
        capacityFull:
        while(wave <= max) {
            for(int s=0; s<schools; s++) {
                if(registered[s] >= wave) {
                    accepted[s]++;
                    totalTeams++;
                }
                if(totalTeams >= capacity) {
                    break capacityFull;
                }
            }
            wave++;
        }
        //출력
        for(int s=0; s<schools; s++) {
            sb.append(accepted[s]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
