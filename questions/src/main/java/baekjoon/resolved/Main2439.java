package baekjoon.resolved;

import java.util.*;

public class Main2439 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2439
        https://www.acmicpc.net/source/50482899
        2022.10.13
    */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            for(int k=0; k<n; k++){
                System.out.printf("%s",k+i>=n-1 ? "*" : " ");
            }
            System.out.println();
        }
    }
}