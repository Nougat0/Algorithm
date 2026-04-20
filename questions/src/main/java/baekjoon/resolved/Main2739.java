package baekjoon.resolved;

import java.util.*;

public class Main2739 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2739
        https://www.acmicpc.net/source/50478809
        2022.10.13
    */
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<9; i++){
            System.out.printf("%d * %d = %d%n",
                    n,i+1,n*(i+1));
        }
    }
}