package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        /*
        0을 만드는 것은 5*2 -> 즉, 5의 배수의 등장횟수 구하기
        1,2,3...n까지 5의 배수 개수 구하기
         */
        bw.write(n/5 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
