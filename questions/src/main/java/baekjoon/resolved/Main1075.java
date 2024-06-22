package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());
        n = n/100 * 100; //백의 자리 밑 나머지 제거
        while(n % f != 0) n += 1;

        bw.write(String.format("%02d%n", n % 100));
        bw.flush();
        bw.close();
        br.close();
    }
}
