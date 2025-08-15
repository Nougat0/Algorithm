package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main16466 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/16466
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); //오름차순 정렬
        int min = 0;
        for(int i=1; i<arr[n]; i++) {
            if(arr[i] != i) { //1부터 순차적으로 보다가 비는 곳
                min = i;
                break;
            }
        }
        System.out.println(min);
        br.close();
    }
}
