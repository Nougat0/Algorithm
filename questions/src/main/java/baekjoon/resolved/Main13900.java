package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main13900 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/13900
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] numbers;
        int n;
        long sum = 0;
        long multiplySum = 0;

        /*
          개별적으로 모두 곱하지 말고, 누적합에서 하나씩 빼면서 계산하기
              a*b + a*c + a*d + a*e
                    b*c + b*d + b*e
                          c*d + c*e
                                d*e

              a * (b + c + d + e)
              b * (    c + d + e)
              c * (        d + e)
              d * (            e)
         */
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        numbers = new int[n];
        for(int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            sum += numbers[i];
        }

        for(int i=0; i<n-1; i++) {
            sum -= numbers[i];
            multiplySum += sum * numbers[i];
        }

        System.out.println(multiplySum);
        br.close();
    }
}
