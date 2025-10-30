package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main3982 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/3982
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCases = Integer.parseInt(br.readLine());
        int[] winCount;
        Map<String, Integer> teamIndex;

        for(int i=0; i<testCases; i++) {
            // 16강~결승까지의 승리 횟수만 기록해서 찾기 (최종 승리한 팀은 4승)
            // 승리한 적 없는 16강의 8개 팀은 기록에서 배제
            winCount = new int[8];
            teamIndex = new HashMap<>();
            int teams = 0;
            for(int match=1; match<=16; match++) {
                st = new StringTokenizer(br.readLine());
                String t1 = st.nextToken();
                String t2 = st.nextToken();
                int g1 = Integer.parseInt(st.nextToken());
                int g2 = Integer.parseInt(st.nextToken());
                String winningTeam = g1 > g2 ? t1 : t2;

                Integer index = teamIndex.putIfAbsent(winningTeam, teams);
                if(index == null) { //처음 기록되는 팀
                    winCount[teams]++;
                    teams++;
                } else { //이미 기록된 팀
                    winCount[index]++;
                }
            }
            //4승한 팀 찾기
            for(String team : teamIndex.keySet()) {
                int index = teamIndex.get(team);
                if(winCount[index] == 4) {
                    sb.append(team).append("\n");
                    break;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
