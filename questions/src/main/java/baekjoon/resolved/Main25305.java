package baekjoon.resolved;

import java.util.*;
import java.io.*;

public class Main25305 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/25305
        https://www.acmicpc.net/source/62211643
        2023.06.18
    */
    public static void main(String[]args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);
        //arr 재활용함
        arr = br.readLine().split(" ");
        br.close();
        int[] num = new int[n];
        for(int i=0; i<n; i++){
            num[i] = Integer.parseInt(arr[i]);
        }

        //n명의 점수를 내림차순으로 나열하여 k번째 점수를 출력하라
        int temp;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(num[i] < num[j]){
                    temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }

        //k번째 점수 출력하기
        System.out.println(num[k-1]);
    }
}