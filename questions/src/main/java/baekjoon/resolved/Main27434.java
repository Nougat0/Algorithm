package baekjoon.resolved;

import java.io.*;
import java.math.BigInteger;

public class Main27434 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/27434
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        BigInteger number;
        if(n == 0 || n == 1) {
            number = BigInteger.ONE;
        } else {
            number = multiplyRange(1, n);
        }
        bw.write(String.valueOf(number));
        bw.flush();
        bw.close();
        br.close();
    }

    // 분할 정복 기법 적용
    // BigInteger는 작은 수 * 큰 수 연산보다
    // 유사한 수끼리 연산하는 것이 시간절약된다고 함
    private static BigInteger multiplyRange(int start, int end) {
        // 범위 내 숫자 하나만 존재할 경우 바로 return
        if(start == end) {
            return BigInteger.valueOf(start);
        }

        int mid = start + (end - start) / 2;
        BigInteger left = multiplyRange(start, mid);
        BigInteger right = multiplyRange(mid + 1, end);
        return left.multiply(right);
    }
}
