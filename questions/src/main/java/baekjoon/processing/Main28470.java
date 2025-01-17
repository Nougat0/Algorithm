package baekjoon.processing;

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
        double[][] input = new double[3][repeat];
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<repeat; j++) {
                input[i][j] = Double.parseDouble(st.nextToken());
            }
        }
        //연산
        int adrenaline = 0; //아드레날린은 항상 정수... 증/감량은 바닥 함수 사용하기 --> ⌊3.7⌋ --> 3
        for(int i=0; i<repeat; i++) {
            //각 동작 시 순서 정하기
            //먼저 하는 동작이 정해진 값에서 RATE만큼 변함
            //증가량 vs 감소량 비교해서 아드레날린 보존가능한 방향으로 정하기
            double hitFirst = Math.floor(input[INCREASE][i]*input[RATE][i]) - input[DECREASE][i];
            double duckFirst = input[INCREASE][i] - Math.floor(input[DECREASE][i]*input[RATE][i]);
            adrenaline += Math.max(hitFirst, duckFirst);
        }
        bw.write(adrenaline + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
