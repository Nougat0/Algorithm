package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main11050 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/11050
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        /*
            n개 중에 k개를 선택하는 조합의 수
            n! / k! * (n-k)!
        */
        int result = getFactorial(n) / (getFactorial(k) * getFactorial(n-k));
        System.out.println(result);
        br.close();
    }

    private static int getFactorial(int v) {
        int result = 1;
        for(int i=v; i>1; i--) {
            result *= i;
        }
        return result;
    }
}
