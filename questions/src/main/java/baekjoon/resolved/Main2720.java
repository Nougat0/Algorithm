package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2720 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2720
        https://www.acmicpc.net/source/78762229
        2024.05.24
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[] coin = new int[] {25, 10, 5, 1}; //사용할 동전 종류 ~ 큰 순서대로 넣기

        for(int i=0; i<t; i++) {
            int change = Integer.parseInt(br.readLine());
            for(int j=0; j<coin.length; j++) {
                bw.write(String.format("%d ", change / coin[j]));
                change %= coin[j]; //남은 잔돈 넣기
            }
            bw.newLine();
        }
        bw.flush();

        bw.close();
        br.close();
    }
}