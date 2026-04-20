package baekjoon.resolved;

import java.util.Scanner;

public class Main11022 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/11022
        https://www.acmicpc.net/source/50530786
        2022.10.14
    */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t, a, b;
        t = sc.nextInt();
        for(int i=0; i<t; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.printf("Case #%d: %d + %d = %d%n",i+1,a,b,a+b);
        }
    }
}