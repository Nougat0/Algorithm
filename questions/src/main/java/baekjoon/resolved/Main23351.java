package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main23351 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //입력 + 초기화
        int potCnt = Integer.parseInt(st.nextToken());
        int initialMoist = Integer.parseInt(st.nextToken());
        int watering = Integer.parseInt(st.nextToken()); //물을 줄 수 있는 연속된 화분의 개수
        int addedMoist = Integer.parseInt(st.nextToken());
        int[] pots = new int[potCnt];
        for(int i=0; i<potCnt; i++) pots[i] = initialMoist;
        int potNo = 0, days = 0;
        //시뮬레이션
        deathOccurred:
        while(true) {
            days++;
            int maxPotNo = potNo + watering;
            //물 주기
            for(; potNo<maxPotNo; potNo++) {
                int index = potNo % potCnt;
                pots[index] += addedMoist;
            }
            //마르기 + 죽었는지 확인
            for(int i=0; i<potCnt; i++) {
                pots[i]--;
                if(pots[i] <= 0) break deathOccurred;
            }
        }
        //출력
        bw.write(days + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
