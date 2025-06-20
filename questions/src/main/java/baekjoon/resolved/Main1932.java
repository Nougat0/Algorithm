package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1932 {
    /*
        https://www.acmicpc.net/problem/1932
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] cases = new int[n+1]; //최대값의 경우 저장
        int[] currentRow = new int[n+1]; //이번 줄 입력값
        //줄마다 진행
        for(int length = 1; length<=n; length++) {
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=length; i++) {
                currentRow[i] = Math.max(cases[i], cases[i-1]) + Integer.parseInt(st.nextToken());
            }
            //이번 줄 최대값들 옮겨담기
            for(int i=1; i<=length; i++) {
                cases[i] = currentRow[i];
            }
        }
        //최대값 찾기
        int maxValue = 0;
        for(int i=1; i<=n; i++) {
            if(maxValue < cases[i]) maxValue = cases[i];
        }
        System.out.println(maxValue);
        br.close();
    }
}
