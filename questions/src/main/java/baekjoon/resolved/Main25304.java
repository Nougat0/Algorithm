package baekjoon.resolved;

import java.util.*;

public class Main25304 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/25304
        https://www.acmicpc.net/source/50520474
        2022.10.14
    */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        int [] arr = new int[2];
        int sum =0;
        for(int i=0; i<n; i++){
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            sum+=arr[0]*arr[1];
        }
        if(sum == x) System.out.print("Yes");
        else System.out.print("No");
    }
}