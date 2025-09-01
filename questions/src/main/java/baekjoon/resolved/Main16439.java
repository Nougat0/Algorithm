package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main16439 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/16439
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] preference = new int[n][c];
        //입력
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++) {
                preference[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //최대값 도출
        int max = 0;
        for(int c1=0; c1<c-2; c1++) {
            for(int c2=c1+1; c2<c-1; c2++) {
                for(int c3=c2+1; c3<c; c3++) {
                    //c1, c2, c3 3개의 치킨 선택 후 만족도 확인
                    int sum = 0;
                    for(int i=0; i<n; i++) {
                        sum += Math.max(preference[i][c1], Math.max(preference[i][c2], preference[i][c3]));
                    }
                    if(sum > max) max = sum;
                }
            }
        }
        System.out.println(max);
        br.close();
    }
}
