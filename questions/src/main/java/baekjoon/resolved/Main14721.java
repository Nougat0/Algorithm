package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main14721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        int n = Integer.parseInt(br.readLine());
        int[][] coords = new int[n][2]; //[x, y]
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            coords[i][0] = Integer.parseInt(st.nextToken());
            coords[i][1] = Integer.parseInt(st.nextToken());
        }
        //브루트 포스
        long minA=0, minB=0, minRSS=Long.MAX_VALUE;
        for(int a=1; a<=100; a++)
            for(int b=1; b<=100; b++) {
                //각 a,b에 대해 RSS 도출 및 최소값 비교
                long currentRSS = 0;
                for(int k=0; k<n; k++)
                    currentRSS += Math.pow(coords[k][1] - (coords[k][0]*a + b), 2);
                if(currentRSS < minRSS) {
                    minRSS = currentRSS;
                    minA = a;
                    minB = b;
                }
            }
        //출력
        bw.write(minA+" "+minB);
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
