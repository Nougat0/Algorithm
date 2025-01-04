package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main15593 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final int coverTime = 1000;
        int[] covered = new int[coverTime]; //전체 근무자 cover 범위
        int[] coveredCopy; //각 근무자를 제외했을 때의 cover 범위 확인용

        int maxCovered = 0; //cover 가능한 최대시간
        int maxCoverTime = 0, minCoverTime = coverTime+1; //탐색범위 줄이기 위한 최소 최대 탐색값

        int guards = Integer.parseInt(br.readLine()); //근무자 수
        int[][] shiftSchedule = new int[guards][2]; //근무일정

        for(int i=0; i<guards; i++) {
            st = new StringTokenizer(br.readLine());
            shiftSchedule[i][0] = Integer.parseInt(st.nextToken());
            shiftSchedule[i][1] = Integer.parseInt(st.nextToken());
            if(shiftSchedule[i][1] > maxCoverTime) //탐색 최대범위 확인
                maxCoverTime = shiftSchedule[i][1];
            if(shiftSchedule[i][0] < minCoverTime) //탐색 최소범위 확인
                minCoverTime = shiftSchedule[i][0];
            for(int j=shiftSchedule[i][0]; j<shiftSchedule[i][1]; j++) {
                covered[j]++; //근무 기록
            }
        }
        //누구를 잘라야 제일 티가 안 날까 (ㅎㄷㄷ)
        for(int i=0; i<guards; i++) {
            coveredCopy = Arrays.copyOf(covered, coverTime);
            int coveredSum = 0;
            for(int j=shiftSchedule[i][0]; j<shiftSchedule[i][1]; j++) {
                coveredCopy[j]--; //근무 취소
            }
            for(int j=minCoverTime; j<=maxCoverTime; j++) { //cover 범위 확인
                if(coveredCopy[j] > 0) coveredSum++;
            }
            if(coveredSum > maxCovered) { //cover 범위 최대값 갱신
                maxCovered = coveredSum;
            }
        }
        System.out.println(maxCovered); //숫자 하나 출력이니까 br 대신 사용해봄ㄴ
        br.close();
    }
}
