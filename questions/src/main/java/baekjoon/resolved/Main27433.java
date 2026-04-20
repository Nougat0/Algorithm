package baekjoon.resolved;

import java.util.*;

public class Main27433 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/27433
        https://www.acmicpc.net/source/69964315
        2023.12.03
    */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println(recursion(sc.nextInt()));

    }

    public static long recursion(long number) {
        long result = 1;
        if(number >= 1)
            result = number * recursion(number-1);
        return result;
    }
}