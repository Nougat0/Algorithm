package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main13298 {
    /*
     * 각 그룹은 로봇 2종류를 가진다 - 각 종류별 최소 1대 존재
     * [입력] 각 로봇 종류의 다리/팔 개수 + 총 다리/팔 개수
     * [출력] 각 종류별 로봇 대수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            //각 입력 값의 범위: 1 ~ 10_000
            int leg1 = Integer.parseInt(st.nextToken());
            int arm1 = Integer.parseInt(st.nextToken());
            int leg2 = Integer.parseInt(st.nextToken());
            int arm2 = Integer.parseInt(st.nextToken());
            int legsTotal = Integer.parseInt(st.nextToken());
            int armsTotal = Integer.parseInt(st.nextToken());

            int count1Guess = 1, count1 = -1, count2 = -1;
            int matches = 0;
            while(matches < 2 && (leg1*count1Guess + leg2) <= legsTotal) { //임의로 다리로 체크 (어차피 팔과 비율은 같음)
                /*
                    [확인할 것]
                    1) 종류1의 개수만큼 다리/팔을 뺐을 때,
                       남은 다리/팔이 종류2의 것으로 나눠 떨어지는지
                    2) 나눠 떨어지는 개수가 leg, arm 모두 같은지
                */
                int legsLeft = legsTotal - count1Guess*leg1;
                int armsLeft = armsTotal - count1Guess*arm1;
                boolean legsAddUp = legsLeft % leg2 == 0;
                boolean armsAddUp = armsLeft % arm2 == 0;
                boolean isAMatch = legsLeft / leg2 == armsLeft / arm2;
                if(legsAddUp && armsAddUp && isAMatch) {
                    matches++;
                    count1 = count1Guess;
                    count2 = legsLeft / leg2;
                }
                count1Guess++; //종류1 개수 추측값
            }
            if(matches == 1) sb.append(count1).append(' ').append(count2);
            else sb.append("?");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
