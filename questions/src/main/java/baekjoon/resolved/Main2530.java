package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2530 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] time = new int[3];
        for(int i=0; i<3; i++) time[i] = Integer.parseInt(st.nextToken());
        int duration = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        //연산
        time[2] += duration % 60; //second
        if(time[2] / 60 > 0) { //초과 시 조정
            int tossTime = time[2] / 60;
            time[2] %= 60;
            time[1] += tossTime;
        }
        time[1] += duration / 60; //minute
        if(time[1] / 60 > 0) { //초과 시 조정
            int tossTime = time[1] / 60;
            time[1] %= 60;
            time[0] += tossTime;
        }
        if(time[0] / 24 > 0) //hour 초과 시 조정
            time[0] %= 24;
        
        //출력
        for(int i=0; i<3; i++) sb.append(time[i]).append(" ");
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
