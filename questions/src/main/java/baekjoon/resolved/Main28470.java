package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main28470 {
    public static final int INCREASE = 0; //증가량
    public static final int DECREASE = 1; //감소량
    public static final int RATE = 2; //증/감 변화 수치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //입력
        int repeat = Integer.parseInt(br.readLine());
        int[][] input = new int[3][repeat];
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<repeat; j++) {
                int value;
                if(i == RATE) { //부동소수점 제거를 위해 입력 시 *10
                    value = (int) (Double.parseDouble(st.nextToken()) * 10);
                } else {
                    value = Integer.parseInt(st.nextToken());
                }
                input[i][j] = value;
            }
        }
        //연산
        long adrenaline = 0; //아드레날린은 항상 정수... 증/감량은 바닥 함수 사용하기 --> ⌊3.7⌋ --> 3
        for(int i=0; i<repeat; i++) {
            //각 동작 시 순서 정하기
            //먼저 하는 동작이 정해진 값에서 RATE만큼 변함
            //증가량 vs 감소량 비교해서 아드레날린 보존가능한 방향으로 정하기
            int hitFirst =  input[INCREASE][i]*input[RATE][i]/10 - input[DECREASE][i];
            int duckFirst = input[INCREASE][i] - input[DECREASE][i]*input[RATE][i]/10;
            adrenaline += Math.max(hitFirst, duckFirst);
        }
        bw.write(adrenaline + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
