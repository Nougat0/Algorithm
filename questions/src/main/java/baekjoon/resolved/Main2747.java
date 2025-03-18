package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2747 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        final int MAX_FIBO = 45;
        int n = Integer.parseInt(br.readLine());
        Fibo fibo = new Fibo(MAX_FIBO + 1);
        bw.write(fibo.getFibo(n) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Fibo {
        int max;
        int[] array;
        public Fibo(int max) {
            this.max = max;
            array = new int[max];
            processFibo();
        }

        public int getFibo(int n) {
            return array[n];
        }

        /**
         * 피보나치 n최대값까지 Bottom-Up 방식 DP 사용
         * @return
         */
        public void processFibo() {
            array[1] = 1;
            for(int i=2; i<max; i++) {
                array[i] = array[i-1] + array[i-2];
            }
        }
    }
}
