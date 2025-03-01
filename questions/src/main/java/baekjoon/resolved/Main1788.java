package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1788 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Fibo fibo = new Fibo();
        bw.write(fibo.fiboExpand(n).toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Fibo {
        long[] fiboSeq;
        public Fibo() {
            this.fiboSeq = new long[1_000_001];
        }

        /**
         * 피보나치 수열 확장판
         * 전개해보면 양수 피보나치와 절대값으로 대칭구조를 이룬다...
         * 다만 n이 음수일 때는 결과가 음수, 양수 번갈아가면서 나옴
         * f(-1)=1, f(-2)=-1, f(-3)=2, f(-4)=-3, f(-5)=5, ...
         * f(1)=1,  f(2)=1,   f(3)=2,   f(4)=3,  f(5)=5, ...
         * @param n x값
         * @return {f(x)의 값이 음수면 -1, 0이면 0, 양수면 1}\n{f(x)의 절대값}
         */
        public StringBuilder fiboExpand(int n) {
            StringBuilder sb = new StringBuilder();
            //첫 줄 : 결과가 양수/0/음수인지 표시
            if(n > 0 || n < 0 && -n % 2 == 1) sb.append(1);
            else if(n == 0) sb.append(0);
            else sb.append(-1);
            //둘째 줄 : 결과의 절대값 구하기
            int index = Math.abs(n); // 0 ~ 양수만 입력되게 함
            fibo(index); //피보나치 수열 전개
            long result = fiboSeq[index];
            sb.append("\n").append(result);
            return sb;
        }

        /**
         * 피보나치 수열 전개
         * Top-Down(재귀)
         * -> Bottom-Up 으로 바꿈 (원인: StackOverFlowError)
         * @param n ( -1000000 ~ 1000000 정수 )
         */
        public void fibo(int n) {
            fiboSeq[0] = 0;
            fiboSeq[1] = 1;
            for(int i=2; i<=n; i++) {
                //1000_000_000 는 문제에서 제시한 최대값+1 이기도 하며 
                //동시에 long 오버플로우 방지 가능
                fiboSeq[i] = (fiboSeq[i-1] + fiboSeq[i-2]) % 1000_000_000;
            }
        }
    }
}
