package baekjoon.resolved;

import java.util.*;

public class Main10952 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/10952
        https://www.acmicpc.net/source/50490034
        2022.10.13
    */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a==0 && b==0)break;
            System.out.println(a+b);
        }
    }
}