package baekjoon.resolved;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main13277 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/13277
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());
        sb.append(a.multiply(b));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
