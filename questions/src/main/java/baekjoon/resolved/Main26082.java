package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main26082 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/26082
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int A = Integer.parseInt(st.nextToken());
        final int B = Integer.parseInt(st.nextToken());
        final long C = Long.parseLong(st.nextToken()); //연산 최대값이 30억이라 long타입 하나 사용
        // B/A * 3 = ?/C
        // B/A*3*C = ? (B는 항상 A의 배수)
        System.out.println(B/A*3*C);
        br.close();
    }
}
