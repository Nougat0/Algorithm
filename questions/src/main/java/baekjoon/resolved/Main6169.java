package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main6169 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/6169
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int timeLimit = Integer.parseInt(st.nextToken());
        int units = Integer.parseInt(st.nextToken());
        int upSeconds = Integer.parseInt(st.nextToken());
        int flatSeconds = Integer.parseInt(st.nextToken());
        int downSeconds = Integer.parseInt(st.nextToken());
        //특정 구간 왕복할 때, 시간 제한 안에 돌아올 수 있는 가장 먼 unit 개수

        int totalTime = 0;
        int unitsReached = 0;
        for(int t=1; t<=units; t++) {
            char letter = br.readLine().charAt(0);
            switch(letter) {
                case 'f': totalTime += flatSeconds * 2; break;
                default: totalTime += (upSeconds + downSeconds);
            }
            if(totalTime > timeLimit) break;
            unitsReached++;
        }
        System.out.println(unitsReached);
        br.close();
    }
}
