package baekjoon.processing;

import java.io.*;
import java.util.StringTokenizer;

public class Main2609 {
    /*
    최대공약수(gcd): 유클리드 호제법 사용해보기
    최소공배수(lcm):
        a = gcd * a'
        b = gcd * b'
        a * b = gcd * gcd * a' * b'
        lcm = gcd * a' * b'
        lcm = a * b / gcd
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int gcd = getGCD(a, b);
        int lcm = a * b / gcd;
        bw.write(gcd + "\n" + lcm);
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 최소공배수 구하는 유클리드 호제법 알고리즘
     * 테스트해보니 a와 b의 크기 순서는 중요하지 않음
     * @param a
     * @param b
     * @return
     */
    public static int getGCD(int a, int b) {
        int remainder; //나머지
        while(a % b != 0) {
            remainder = a % b;
            a = b;
            b = remainder;
        }
        return b;
    }
}
