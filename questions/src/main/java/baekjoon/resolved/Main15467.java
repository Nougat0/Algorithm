package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main15467 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/15467
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] cards = new int[14];
            for(int j=0; j<6; j++) {
                int number = Integer.parseInt(st.nextToken());
                cards[number]++;
            }
            //경우 확인
            int[] count = new int[5];
            for(int j=1; j<=13; j++) {
                count[cards[j]]++;
            }
            //분기
            if(count[4] > 0) {
                if(count[2] == 1) sb.append("tiki pair");
                else sb.append("tiki");
            } else if(count[3] > 0) {
                if(count[3] == 2) sb.append("two triples");
                else if(count[3] == 1) {
                    if(count[2] == 1) sb.append("full house");
                    else sb.append("one triple");
                }
            } else if(count[2] > 0) {
                int count2 = count[2];
                if(count2 == 3) sb.append("three pairs");
                else if(count2 == 2) sb.append("two pairs");
                else if(count2 == 1) sb.append("one pair");
            } else {
                sb.append("single");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
