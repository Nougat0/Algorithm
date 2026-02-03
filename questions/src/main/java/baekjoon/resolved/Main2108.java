package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2108 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2108
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] mo = new int[8_001]; // -4000 ~ 0 ~ 4000
        int[] no = new int[n];
        double sum = 0;
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            mo[num + 4_000]++; //보정 계수 4_000
            no[i] = num;
        }

        Arrays.sort(no);
        int min = no[0];
        int max = no[n-1];
        double avg = sum / n;
        int center = no[n/2]; //N은 홀수
        int[] most = new int[2]; //최빈값 최소값 2번째까지 확인
        int range = max - min;

        int count = 0;
        int index = 0;
        for(int i=min; i<=max; i++) {
            if(mo[i+4_000] > count) {
                //최빈값 갱신
                index = 0;
                most[index++] = i;
                count = mo[i+4_000];
            } else if(mo[i+4_000] == count){
                //동일 최빈값 2개까지만 저장
                if(index < 2) {
                    most[index++] = i;
                    count = mo[i+4_000];
                }
            }
        }

        sb.append(Math.round(avg)).append("\n");
        sb.append(center).append("\n");
        sb.append(index == 2 ? most[1] : most[0]).append("\n");
        sb.append(range).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
