package baekjoon.resolved;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main11005 {
    /*
        https://www.acmicpc.net/problem/11005
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/source/78712875
        2024.05.23
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        bw.write(
                Integer.toString(
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())
                ).toUpperCase()
        );
        bw.newLine();
        bw.flush();

        bw.close();
        br.close();
    }
}
