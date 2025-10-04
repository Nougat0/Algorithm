package baekjoon.processing;

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
        while(true) {
            st = new StringTokenizer(br.readLine());
            BigInteger a = new BigInteger(st.nextToken());
            BigInteger b = new BigInteger(st.nextToken());
            if(a.equals(BigInteger.ZERO) && b.equals(BigInteger.ZERO)) break;

            BigInteger v1 = BigInteger.TWO;
            BigInteger v2 = BigInteger.ONE;
            BigInteger v0;
            int count = 0;

            if(v1.compareTo(a) >= 0) count++;
            if(v2.compareTo(a) >= 0) count++;

            while((v0 = v1.add(v2)).compareTo(b) <= 0) {
                if(v0.compareTo(a) >= 0) count++;
                v2 = v1;
                v1 = v0;
            }
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
