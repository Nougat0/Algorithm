package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main11896 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/11896
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final long A = Long.parseLong(st.nextToken());
        final long B = Long.parseLong(st.nextToken());
        long newA = (A - 1) / 2; //A를 제외 (A-1)까지만 빼기
        long newB = B / 2; //B를 포함
        // 2의 배수인 N각형만 가능하다
        // [origin] 4 6 8 10 12 14 16 18 ... -> [new] 2 3 4 5 6 7 8 9 ...
        long sumA = newA * (newA + 1); // 1~(A-1) 까지의 합
        long sumB = newB * (newB + 1); // 1~B 까지의 합
        long sum = sumB - sumA;
        if(!(A == 1 && B == 1) && A <= 2) sum -= 2; //2각형은 제외
        System.out.println(sum); // 1~B 합에서 1~A 합을 뺌
        br.close();
    }
}
