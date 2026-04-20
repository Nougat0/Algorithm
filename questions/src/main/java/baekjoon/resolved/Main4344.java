package baekjoon.resolved;

import java.util.*;

public class Main4344 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/4344
        https://www.acmicpc.net/source/50736164
        2022.10.19
    */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum=0; int count=0; double p=0;
        int[] arr;
        for(int i=0;i<n;i++){
            arr = new int[sc.nextInt()];
            for(int k=0;k<arr.length;k++){
                arr[k] = sc.nextInt();
                sum +=arr[k];
            }///for
            p = ((double)sum/arr.length);
            for(int j=0;j<arr.length;j++){
                if(arr[j] > p) count++;
            }///for
            System.out.printf("%.3f%%%n",(double)count/arr.length*100);
            count=0;
            sum=0;
        }///for
    }
}