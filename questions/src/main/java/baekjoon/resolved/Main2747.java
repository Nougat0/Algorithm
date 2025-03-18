package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2747 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Fibo fibo = new Fibo(n + 1);
        bw.write(fibo.getFibo(n) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Fibo {
        int[] array;
        public Fibo(int n) {
            array = new int[n];
        }

        /**
         * 피보나치 수열 값 구하기 (Top-Down)
         * @param n
         * @return
         */
        public int getFibo(int n) {
            if(n == 0) return 0;
            else if(n == 1) return 1;
            else if(array[n] > 0) return array[n];
            else {
                int result = getFibo(n-1) + getFibo(n-2);
                return (array[n] = result);
            }
        }
    }
}
