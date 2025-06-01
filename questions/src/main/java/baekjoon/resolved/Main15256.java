package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main15256 {
    /*
        https://www.acmicpc.net/problem/15256
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int dataSets = Integer.parseInt(br.readLine());
        for(int dataSet=1; dataSet<=dataSets; dataSet++) {
            sb.append("Data Set ").append(dataSet).append(":\n");
            int steps = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int stepsFromStart = 0;
            boolean hitInterval = false;
            double minDistance = 101.0; //최대값으로 초기화
            while(steps-- > 0) {
                double step = Double.parseDouble(st.nextToken());
                if(!hitInterval) { //시작점 찍었는지 확인
                    if(step >= 30.0 && step <= 30.2) hitInterval = true;
                } else {
                    stepsFromStart++; //시작점 찍고부터 3번 점프 확인
                    if(stepsFromStart >= 3 && step < minDistance) {
                        minDistance = step; //3번 이상부터는 최소 거리 확인
                    }
                }
            }
            if(!hitInterval || stepsFromStart < 3) {
                sb.append("0.00");
            } else {
                sb.append(String.format("%.2f", minDistance - 30.0));
            }
            //줄바꿈 조건
            if(dataSet < dataSets) sb.append("\n\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
