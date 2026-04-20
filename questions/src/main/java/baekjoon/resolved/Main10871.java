package baekjoon.resolved;

import java.util.*;

public class Main10871 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/10871
        https://www.acmicpc.net/source/50483378
        2022.10.13
    */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int x = sc.nextInt();
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            if(arr[i] < x) {
                System.out.print(arr[i]);
                System.out.print(" ");
            }
        }
    }
}