package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1546 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/1546
        https://www.acmicpc.net/source/78083662
        2024.05.09
    */
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] subject = new double[n]; //0.0점 초기화
        double max = 0;
        String[] scores = br.readLine().split(" ");

        for(int i=0; i<n; i++){
            int score = Integer.parseInt(scores[i]);
            subject[i] = score;
            //최대값 구하기
            if(score > max) max = score;
        }

        //계산
        double avg = 0.0;
        for(int i=0; i<n; i++) {
            subject[i] = subject[i]/max*100;
            avg += subject[i];
        }
        avg = avg/n;

        //출력
        System.out.println(avg);
    }
}
