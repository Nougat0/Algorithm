package baekjoon.resolved;

import java.util.*;

public class Main1110 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/1110
        https://www.acmicpc.net/source/50495832
        2022.10.13
    */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m =n;
        int c=0;
        while(true){
            if(n<10) n+=n*10;
            else {
                int f = n/10;
                int s = n%10;
                int t = f+s;
                if(t>=10) t=t%10;
                n = s*10+(t);
            }///else
            c++;
            if(n==m) break;
        }///while
        System.out.print(c);
    }///main
}///class