package baekjoon.resolved;

import java.io.*;
import java.math.BigInteger;

public class Main2338 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2338
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());
        sb.append(a.add(b)).append("\n").append(a.subtract(b)).append("\n").append(a.multiply(b));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
