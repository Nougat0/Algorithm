package baekjoon.resolved;

import java.io.*;

public class Main24416 {
    /*
        https://www.acmicpc.net/problem/24416
        https://www.acmicpc.net/user/bcdlife
    */
    public static int countRecursive = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        fib(n); // 재귀함수 실행
        //DP 방식은 n-2 번 실행한다고 표현 가능
        sb.append(countRecursive).append(' ').append(n-2);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /* 피보나치 재귀호출 의사 코드
    fib(n) {
        if (n = 1 or n = 2)
        then return 1;  # 코드1
        else return (fib(n - 1) + fib(n - 2));
    }
    */
    public static int fib(int n) {
        if(n == 1 || n == 2) {
            countRecursive++;
            return 1;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }
}
