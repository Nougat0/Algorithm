package baekjoon.processing;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main14182 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/14182
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //세전 값을 줄 테니 세후 값 계산하라
        while(true) {
            int income = Integer.parseInt(br.readLine());
            if(income == 0) break;

            if(income <= 1_000_000) {
                sb.append(income);
            } else if(income > 5_000_000) {
                sb.append(income/100 * 80);
            } else {
                sb.append(income/100 * 90);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
