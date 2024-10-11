package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int teams = Integer.parseInt(st.nextToken());
        int brokenTeams = Integer.parseInt(st.nextToken());
        int spareTeams = Integer.parseInt(st.nextToken());
        int[] teamList = new int[teams];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<brokenTeams; i++) {
            int brokenTeam = Integer.parseInt(st.nextToken());
            teamList[brokenTeam - 1]--;
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<spareTeams; i++) {
            int spareTeam = Integer.parseInt(st.nextToken());
            teamList[spareTeam - 1]++;
        }
        //연산
        for(int i=0; i<teams; i++)
            if(teamList[i] == -1) //카약이 부서진 팀
                if(i-1 >=0 && teamList[i-1] == 1) { //앞의 팀이 여분 있을 경우 빌려오기
                    teamList[i-1]--;
                    teamList[i]++;
                } else if(i+1 < teams && teamList[i+1] == 1) { //뒤의 팀이 여분 있을 경우 빌려오기
                    teamList[i+1]--;
                    teamList[i]++;
                }
        //결과 확인
        int cannotStartTeams = 0;
        for(int i=0; i<teams; i++)
            if(teamList[i] == -1) cannotStartTeams++;
        //출력
        bw.write(cannotStartTeams + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}



