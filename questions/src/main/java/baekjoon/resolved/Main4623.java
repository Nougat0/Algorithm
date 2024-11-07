package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main4623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] testcase;
        //입력, 연산
        while(true) {
            testcase = new int[4];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++) testcase[i] = Integer.parseInt(st.nextToken());
            if(testcase[0] == 0 && testcase[1] == 0 && testcase[2] == 0 && testcase[3] == 0) break;

            //회전하기 (긴변끼리 정렬, 짧은 변끼리 정렬)
            double imageMax = Math.max(testcase[0], testcase[1]);
            double imageMin = Math.min(testcase[0], testcase[1]);
            double paperMax = Math.max(testcase[2], testcase[3]);
            double paperMin = Math.min(testcase[2], testcase[3]);
            Double percent;

            if(paperMax >= imageMax && paperMin >= imageMin) {
                percent = 100.0;
            } else { //긴 변과 짧은 변 중 어느 변에 맞춰서 줄여야 꽉 맞게 들어갈 수 있는지 모름
                double maxSidePercent = paperMax/imageMax * 100;
                double minSidePercent = paperMin/imageMin * 100;
                //긴 변에 맞춰서 줄였을 때 들어간다면 긴 변의 줄어든 % 사용
                if(maxSidePercent * imageMin / 100 <= paperMin)
                    percent = maxSidePercent;
                else //긴 변에 맞춰 줄이면 짧은 변이 튀어나오는 경우 -> 짧은 변의 줄어든 % 사용
                    percent = minSidePercent;
            }
            sb.append(percent.intValue()); //정수값만 출력
            sb.append("%\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
