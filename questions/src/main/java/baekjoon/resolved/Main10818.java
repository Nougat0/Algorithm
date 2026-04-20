package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main10818 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/10818
        https://www.acmicpc.net/source/77188698
        2024.04.19
    */
    public static void main(String[] args) {
        //입력
        Scanner sc = new Scanner(System.in);
        sc.nextLine(); //n 미사용
        String[] numbers = sc.nextLine().split(" ");

        //출력
        int max = Integer.parseInt(numbers[0]);
        int min = Integer.parseInt(numbers[0]);

        for(String number: numbers){
            int num = Integer.parseInt(number);
            if(num > max) max = num;
            else if(num < min) min = num;
        }
        System.out.printf("%d %d", min, max);
    }
}