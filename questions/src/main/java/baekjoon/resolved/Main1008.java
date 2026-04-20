package baekjoon.resolved;

import java.util.Scanner;

public class Main1008 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/1008
        https://www.acmicpc.net/source/50164967
        2022.10.06
    */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        double c = (double)a/b;
        System.out.print(c);
    }
}