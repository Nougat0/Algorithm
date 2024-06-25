package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력 + 출력
        int t = Integer.parseInt(br.readLine());
        double[] testCase = new double[6];
        double distance = 0;
        int code = -1;
        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<6; j++) testCase[j] = Double.parseDouble(st.nextToken());
            //조규현과 백승환 사이의 거리
            distance = Math.sqrt(Math.pow(testCase[0]-testCase[3], 2) + Math.pow(testCase[1]-testCase[4], 2));
            if(distance == 0) { //조규현 위치 == 백승환 위치
                if(testCase[2] == testCase[5]) code = -1;
                else code = 0;
            } else { //조규환 위치 != 백승환 위치
                if(distance < Math.abs(testCase[2]-testCase[5])) code = 0; //첫 시도에서 누락된 조건 (포함관계의 원)
                else if(distance == Math.abs(testCase[2]-testCase[5])) code = 1; //N번재 시도에서 누락된 조건 (내접하는 원)
                else if(distance < testCase[2]+testCase[5]) code = 2;
                else if(distance == testCase[2]+testCase[5]) code = 1;
                else if(distance > testCase[2]+testCase[5]) code = 0;
            }
            bw.write(code + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
