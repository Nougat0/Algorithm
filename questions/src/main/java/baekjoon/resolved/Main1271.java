package baekjoon.resolved;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main1271 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger money = new BigInteger(st.nextToken());
        BigInteger lives = new BigInteger(st.nextToken());

        bw.write(money.divide(lives).toString()+"\n");
        bw.write(money.remainder(lives).toString()+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
