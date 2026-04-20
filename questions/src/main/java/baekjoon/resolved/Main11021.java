package baekjoon.resolved;

import java.util.*;

public class Main11021 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/11021
        https://www.acmicpc.net/source/50530623
        2022.10.14
    */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int a=0;
        int b=0;
        for(int i=0; i<t; i++){
            a=sc.nextInt();
            b=sc.nextInt();
            System.out.printf("Case #%d: %d%n",i+1,a+b);
        }
    }
}