package baekjoon.resolved;

import java.util.*;

public class Main10870 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/10870
        https://www.acmicpc.net/source/69964486
        2023.12.03
    */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n){
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else { //n >= 2
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}