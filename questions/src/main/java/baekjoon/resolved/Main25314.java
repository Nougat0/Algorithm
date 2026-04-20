package baekjoon.resolved;

import java.util.Scanner;

public class Main25314 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/25314
        https://www.acmicpc.net/source/76712290
        2024.04.10
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nDivide4 = sc.nextInt() / 4;
        String dataType = new String("");
        for (int i=0; i<nDivide4; i++) {
            dataType = dataType.concat("long ");
            if (i == nDivide4 - 1) dataType = dataType.concat("int");
        }

        System.out.println(dataType);
    }
}