package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main3943 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(getBiggestNum(n)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 헤일스톤 수열 진행,
     * 수열 중 가장 큰 수 반환
     * @param n 헤일스톤 수열의 시작값
     * @return max
     */
    public static int getBiggestNum(int n) {
        int max = n;
        //hailstone sequence
        while(n != 1) {
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n *= 3;
                n++;
            }
            if(n > max) {
                max = n;
            }
        }
        return max;
    }
}
