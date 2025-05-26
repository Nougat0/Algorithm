package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main33989 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/contest/problem/1476/6
        https://www.acmicpc.net/problem/33989
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        char[] coins = br.readLine().toCharArray();
        int[][] sumCoins = new int[n][2]; //B, D
        int countB = 0;
        int countD = 0;
        int lastB = -1, lastD = -1;
        for(int i=0; i<n; i++) {
            char frontCoin = coins[i];
            char backCoin = coins[n-1-i];
            //동전 혼합구간 기록
            if(lastB == -1 && frontCoin == 'D') lastB = i;
            if(lastD == -1 && backCoin == 'B') lastD = n-1-i;
            //동전 종류별 누적값 기록하기
            if(frontCoin == 'B') countB++;
            else countD++;
            sumCoins[i][0] = countB;
            sumCoins[i][1] = countD;
        }
        //혼합구간에서 적은 종류의 개수 구하기
        int sumB = sumCoins[lastD][0] - (lastB-1 >= 0 ? sumCoins[lastB-1][0] : 0);
        int sumD = sumCoins[lastD][1] - (lastB-1 >= 0 ? sumCoins[lastB-1][1] : 0);

        bw.write(Math.min(sumB, sumD) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}