package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main25965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //게임 입력
        int games = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int g=0; g<games; g++) {
            long donation = 0;
            //미션 입력
            int missions = Integer.parseInt(br.readLine());
            long[][] missionList= new long[missions][3];
            for(int m=0; m<missions; m++) {
                st = new StringTokenizer(br.readLine());
                missionList[m][0] = Long.parseLong(st.nextToken()); //moneyForKill
                missionList[m][1] = - Long.parseLong(st.nextToken()); //moneyForDeath
                missionList[m][2] = Long.parseLong(st.nextToken()); //moneyForAssist
            }
            //스탯 입력
            int[] stats= new int[3];
            st = new StringTokenizer(br.readLine());
            stats[0] = Integer.parseInt(st.nextToken()); // kill
            stats[1] = Integer.parseInt(st.nextToken()); // death
            stats[2] = Integer.parseInt(st.nextToken()); // assist
            //연산
            for(int m=0; m<missions; m++) {
                long missionMoney = 0;
                for(int i=0; i<3; i++) missionMoney += stats[i]*missionList[m][i];
                if(missionMoney > 0) donation += missionMoney;
            }
            //출력
            bw.write(donation + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
