package baekjoon.resolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5597 {
    public static void main(String[] args) throws IOException {
        int[] students = new int[30]; //기본값 0
        int[] noSubmit = new int[2]; //기본값 0
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<28; i++) {
            students[Integer.parseInt(br.readLine())-1] = 1; //제출: 1
        }
        br.close();
        //미제출 출석번호 찾기
        for(int i=0; i<30; i++) {
            if (students[i] == 0 ) {
                //담는 과정에서 정렬
                if(noSubmit[0] == 0) noSubmit[0] = i+1;
                else noSubmit[1] = i+1;
            }
        }
        //출력
        for(int i=0; i<2; i++) {
            System.out.println(noSubmit[i]);
        }
    }
}