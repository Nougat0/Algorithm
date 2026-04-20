package baekjoon.resolved;

import java.util.Scanner;

public class Main10807 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/10807
        https://www.acmicpc.net/source/77188444
        2024.04.19
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //입력
        sc.nextLine(); //정수의 개수 활용 안함
        String[] numbers = sc.nextLine().split(" ");
        int v = Integer.parseInt(sc.nextLine());
        int count = 0;

        //반복문
        for(String number: numbers) {
            if(Integer.parseInt(number) == v) count++;
        }
        System.out.println(count);

    }
}