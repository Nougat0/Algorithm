package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main33989 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/contest/problem/1476/6
        https://www.acmicpc.net/problem/33989
    */
    public static final int B = 0;
    public static final int D = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        char[] coins = br.readLine().toCharArray();
        int[][] sumCoins = new int[N+1][2]; //[B, D] N+1 길이로 지정 (첫번째 값 0)
        int countB = 0;
        int countD = 0;
        int lastB = -1, lastD = -1; //마지막으로 등장하는 곳
        int firstB = -1, firstD = -1; //최초로 등장하는 곳
        final int FIRST_INDEX = 0;
        final int LAST_INDEX = N-1;
        for(int i=FIRST_INDEX; i<N; i++) {
            char frontCoin = coins[i];
            char backCoin = coins[LAST_INDEX-i];
            //동전 혼합구간 기록 (최초/마지막 B와 D)
            if(frontCoin == 'B') lastB = i;
            if(backCoin == 'D') lastD = LAST_INDEX-i;

            if(firstB == -1 && frontCoin == 'B') firstB = i;
            if(firstD == -1 && backCoin == 'D') firstD = LAST_INDEX-i;
            //동전 종류별 누적값 기록하기
            if(frontCoin == 'B') countB++;
            else countD++;
            sumCoins[i+1][B] = countB;
            sumCoins[i+1][D] = countD;
        }
        //조정구간 탐색
        if((lastD == -1 || lastB == -1) || (lastB - lastD + 1 == 0)) { //[*] 혼합구간 부재
            bw.write(0 + "\n");
        } else { //[*] 혼합구간 존재
            int mixStart = lastD;
            int mixEnd = lastB+1; //N+1 길이에 맞춰 index 조정

            //혼합구간에서 적은 종류의 개수 구하기
            int mixedB = sumCoins[mixEnd][B] - sumCoins[mixStart][B];
            int mixedD = sumCoins[mixEnd][D] - sumCoins[mixStart][D];
            bw.write(Math.min(mixedB, mixedD) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}