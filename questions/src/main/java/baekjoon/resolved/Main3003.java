package baekjoon.resolved;

import java.util.Scanner;

public class Main3003 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/3003
        https://www.acmicpc.net/source/50446744
        2022.10.12
    */
    public static void main(String[]agrs){
        // 킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개
        // sc + () = 1 // sc-1 = -()
        Scanner sc = new Scanner(System.in);
        int kingDiff = -((sc.nextInt())-1);
        int queenDiff = -((sc.nextInt())-1);
        int rookDiff = -((sc.nextInt())-2);
        int bishopDiff = -((sc.nextInt())-2);
        int knightDiff = -((sc.nextInt())-2);
        int pawnDiff = -((sc.nextInt())-8);
        System.out.printf("%d %d %d %d %d %d",
                kingDiff,
                queenDiff,
                rookDiff,
                bishopDiff,
                knightDiff,
                pawnDiff);
    }
}