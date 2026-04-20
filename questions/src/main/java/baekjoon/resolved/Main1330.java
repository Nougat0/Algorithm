package baekjoon.resolved;

import java.util.*;

public class Main1330 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/1330
        https://www.acmicpc.net/source/50449366
        2022.10.12
    */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a>b) System.out.print(">");
        else if(a<b) System.out.print("<");
        else System.out.print("==");
    }
}