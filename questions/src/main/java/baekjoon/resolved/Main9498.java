package baekjoon.resolved;

import java.util.*;

public class Main9498 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/9498
        https://www.acmicpc.net/source/50449505
        2022.10.12
    */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a>=90 && a<=100) System.out.print("A");
        else if(a>=80 && a<90) System.out.print("B");
        else if(a>=70 && a<80) System.out.print("C");
        else if(a>=60 && a<70) System.out.print("D");
        else System.out.print("F");
    }
}