package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main3052 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/3052
        https://www.acmicpc.net/source/77935254
        2024.05.06
    */
    public static void main(String[] args) throws IOException {
        int[] remainder = new int[10]; //기본값 0
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<10; i++) remainder[i] = Integer.parseInt(br.readLine()) % 42;
        br.close();

        //중복제거 후 길이 출력
        System.out.println(Arrays.stream(remainder).distinct().toArray().length);
    }
}