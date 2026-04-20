package baekjoon.resolved;

import java.util.*;

public class Main8393 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/8393
        https://www.acmicpc.net/source/50479023
        2022.10.13
    */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum=0;
        for(int i=1; i<n+1; i++){
            sum+=i;
        }
        System.out.print(sum);
    }
}