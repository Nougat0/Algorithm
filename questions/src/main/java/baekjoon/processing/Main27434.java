package baekjoon.processing;

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
        BigInteger number = BigInteger.ONE;
        for(int i=1; i<=n; i++) {
            number = number.multiply(BigInteger.valueOf(i));
        }
        bw.write(String.valueOf(number));
        bw.flush();
        bw.close();
        br.close();
    }
}
