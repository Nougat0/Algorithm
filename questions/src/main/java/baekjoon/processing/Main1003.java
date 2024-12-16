package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main1003 {
    public static Fibonacci[] add = new Fibonacci[41];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++) {
            Fibonacci f = new Fibonacci().count(Integer.parseInt(br.readLine()));
            f.printString(sb);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Fibonacci {
        int zeroCount;
        int oneCount;

        public Fibonacci() {
            this.zeroCount = 0;
            this.oneCount = 0;
        }

        public Fibonacci(int zeroCount, int oneCount) {
            this.zeroCount = zeroCount;
            this.oneCount = oneCount;
        }

        public Fibonacci add(Fibonacci f) {
            return new Fibonacci(this.zeroCount + f.zeroCount, this.oneCount + f.oneCount);
        }

        public Fibonacci count(int n) {
            Fibonacci result = new Fibonacci(0,0);
            /*값이 이미 계산되었을 경우*/
            if(add[n] != null) {
                result =  add[n];
            }
            /*값이 아직 계산되지 않은 경우*/
            else if(add[n] == null) {
                if(n == 0) {
                    result = new Fibonacci(1, 0);
                } else if(n == 1) {
                    result = new Fibonacci(0, 1);
                } else {
                    Fibonacci a = count(n-1);
                    Fibonacci b = count(n-2);
                    result = a.add(b);
                }
                add[n] = result;
            }
            return result;
        }

        public void printString(StringBuilder sb) {
            sb.append(zeroCount).append(" ").append(oneCount).append("\n");
        }
    }
}
