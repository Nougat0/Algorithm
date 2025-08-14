package baekjoon.resolved;

import java.io.*;

public class Main23530 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/23530
    */
    public static final String ONE = "1\n";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        //a, b 최소값이 1이므로 a+b 는 절대 1이 될 수 없음
        sb.append(ONE.repeat(n));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
