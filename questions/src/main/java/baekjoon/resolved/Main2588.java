package baekjoon.resolved;

import java.util.*;

public class Main2588 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2588
        https://www.acmicpc.net/source/50447621
        2022.10.12
    */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        int c = a*(b%10);
        int d = a*((b%100)/10);
        int e = a*(b/100);
        int f = c+d*10+e*100;
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
    }
}