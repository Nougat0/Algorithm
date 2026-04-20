package baekjoon.resolved;

import java.util.Scanner;

public class Main18108 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/18108
        https://www.acmicpc.net/source/50400142
        2022.10.11
    */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int buddism = Integer.parseInt(sc.nextLine().trim());
        int diff = 2541-1998;
        System.out.println(buddism-diff);
    }
}