package baekjoon.resolved;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main6571 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/6571
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        //dp 로 피보나치
        BigInteger[] arr = new BigInteger[1001];
        arr[1] = BigInteger.ONE;
        arr[2] = BigInteger.TWO;
        for(int i=3; i<1001; i++) {
            arr[i] = arr[i-1].add(arr[i-2]);
        }

        while(true) {
            st = new StringTokenizer(br.readLine());
            BigInteger a = new BigInteger(st.nextToken());
            BigInteger b = new BigInteger(st.nextToken());
            if(a.equals(BigInteger.ZERO) && b.equals(BigInteger.ZERO)) break;

            int count = 0;
            int i = 1;
            while(arr[i].compareTo(b) <= 0) {
                if(arr[i].compareTo(a) >= 0) count++;
                i++;
            }
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
