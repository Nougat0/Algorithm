package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        /*
        0을 만드는 것은 5*2 -> 즉, 5의 배수의 등장횟수 구하기
        1,2,3...n까지 5의 배수 개수 구하기
        +)
        5의 배수라고 무조건 5가 1번만 곱해진 것은 아님
        25의 배수,125의 배수는 5가 2,3번 곱해짐 (0<=n<=500)
         */
        bw.write((n/5 + n/25 + n/125) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
