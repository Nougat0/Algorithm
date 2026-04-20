package baekjoon.resolved;

import java.util.Scanner;

public class Main2480 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2480
        https://www.acmicpc.net/source/50478525
        2022.10.13
    */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int temp;

        if(a==b && a==c) System.out.print(a*1000+10000);
        if(a==b && a!=c || a==c && a!=b || b==c && b!=a){
            if(a==b || a==c) System.out.print(a*100+1000);
            else System.out.print(b*100+1000);
        }
        if(a!=b && b!=c && a!=c) {
            if(a>b && a>c) System.out.print(a*100);
            else if(b>a && b>c) System.out.print(b*100);
            else if(c>a && c>b) System.out.print(c*100);
        }
    }
}