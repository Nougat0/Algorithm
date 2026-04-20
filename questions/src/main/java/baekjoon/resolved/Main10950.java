package baekjoon.resolved;

import java.util.*;

public class Main10950 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/10950
        https://www.acmicpc.net/source/50520409
        2022.10.14
    */
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int[2];
        for(int i=0;i<t;i++){
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            System.out.println(arr[0]+arr[1]);
        }
    }
}