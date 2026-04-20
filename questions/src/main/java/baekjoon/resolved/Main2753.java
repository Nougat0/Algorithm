package baekjoon.resolved;

import java.util.*;

public class Main2753 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/14681
        https://www.acmicpc.net/source/50449674
        2022.10.12
    */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        if(y%4==0 && (y%100 !=0 || y%400==0)) System.out.print("1");
        else System.out.print("0");
    }
}