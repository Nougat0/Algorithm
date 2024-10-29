package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main18310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //입력
        int houseCnt = Integer.parseInt(br.readLine());
        int[] houses = new int[houseCnt];
        st = new StringTokenizer(br.readLine());
        for(int h=0; h<houseCnt; h++) houses[h] = Integer.parseInt(st.nextToken());
        //적절한 안테나의 위치 선정
        long minDistance = Long.MAX_VALUE;
        int houseNo = 0;
        for(int h=0; h<houseCnt; h++) {
            long distance = 0;
            for(int i=0; i<houseCnt; i++) {
                if(h==i) continue;
                distance += Math.abs(houses[h] - houses[i]);
            }
            if(distance < minDistance) {
                minDistance = distance;
                houseNo = h;
            }
        }
        //출력
        bw.write(houses[houseNo] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
