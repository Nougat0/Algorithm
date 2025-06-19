package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1149 {
    /*
        https://www.acmicpc.net/problem/1149
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        final int R = 0;
        final int G = 1;
        final int B = 2;
        int n = Integer.parseInt(br.readLine());
        int[] minimum = new int[3]; //줄마다 각 자리 선택 시 최소값
        int[] current = new int[3]; //이번에 받은 R/G/B 값
        st = new StringTokenizer(br.readLine());
        minimum[R] = Integer.parseInt(st.nextToken());
        minimum[G] = Integer.parseInt(st.nextToken());
        minimum[B] = Integer.parseInt(st.nextToken());

        int newMinPriceR, newMinPriceG, newMinPriceB;
        for(int i=1; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            current[R] = Integer.parseInt(st.nextToken());
            current[G] = Integer.parseInt(st.nextToken());
            current[B] = Integer.parseInt(st.nextToken());
            //이번에 R/G/B (자리) 를 선택하면 가능한 최솟값 구하기
            //새로 추가되는 값에 따라 이전의 최소값 선택seq가 달라질 수 있음 -> 각 자리마다 구해놓고 있어야 함
            newMinPriceR = Math.min(minimum[G], minimum[B]) + current[R]; //R 선택 시 최소값
            newMinPriceG = Math.min(minimum[R], minimum[B]) + current[G]; //G 선택 시 최소값
            newMinPriceB = Math.min(minimum[G], minimum[R]) + current[B]; //B 선택 시 최소값
            minimum[R] = newMinPriceR;
            minimum[G] = newMinPriceG;
            minimum[B] = newMinPriceB;
        }
        System.out.println(Math.min(Math.min(minimum[R], minimum[G]), minimum[B]));
        br.close();
    }
}
