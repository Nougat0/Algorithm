package baekjoon.resolved;

import java.util.*;

public class Main14681 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/14681
        https://www.acmicpc.net/source/50449924
        2022.10.12
    */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        int y = Integer.parseInt(sc.nextLine());
        if(x>0){
            if(y>0) System.out.print("1");
            else System.out.print("4");
        }
        else if(y>0) System.out.print("2");
        else System.out.print("3");
    }
}