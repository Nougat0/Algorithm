package baekjoon.resolved;

import java.util.Scanner;

public class Main11382 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/11382
        https://www.acmicpc.net/source/76709502
        2024.04.10
    */
    public static void main(String [] args) {
        long sum = 0L;
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] numbers = input.split(" ");

        for(String number : numbers) sum += Long.parseLong(number);
        System.out.println(sum);
    }

}