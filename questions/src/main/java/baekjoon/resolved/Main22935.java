package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main22935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1,2,3,...,15,14,13,...2 까지가 1 loop -> 28 차례
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for(int t=0; t<testCase; t++) {
            int turn = Integer.parseInt(br.readLine()) % 28;
            if(turn == 0) turn = 2; //입력된 turn이 28의 배수일 경우 0이 되어버리는 현상 제어
            if(turn / 15 > 0) { //내림차순 숫자
                turn = 15 - (turn % 15); //외칠 숫자 구하기
            }

            /*
                이진수 구하는 방식 (오 -> 왼)과
                StringBuilder.append 방식 (왼 -> 오)이 서로 달라서
                for문 2번 돌림
                (sb.insert는 고려 대상 아님)
            */
            
            //이진수 직접 구하기
            int[] binary = new int[4];
            for(int i=3; turn != 0; i--) {
                binary[i] = turn % 2;
                turn = turn / 2;
            }
            //이진수에 따른 출력 형태
            for(int num : binary) {
                sb.append(num == 0 ? 'V' : "딸기");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
