package baekjoon.processing;

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main11009 {
    /*
        https://www.acmicpc.net/problem/11009
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        /*
            테스트 케이스별로 확률 분수 구하기

            dreamoon이 빨간 공을 먼저 뽑을 확률 구하기
            1, 3, 5, ... 흰 공이 없어질 때까지 각 차례마다 뽑을 확률 구해서 덧셈

            빨간 공 2개 + 흰 공 3개
            1: [2/5]
                dreamoon이 바로 빨간 공을 뽑음
            3: 3/5 + 2/4 + [2/3]
                dreamoon이 흰 공을 뽑음
                drazil이 흰 공을 뽑음
                dreamoon이 빨간 공을 뽑음
            5: X
                흰 공의 개수가 부족하여 5번째 차례까지 이어지지 않음
        */
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            final int RED_BALLS = Integer.parseInt(st.nextToken());
            final int WHITE_BALLS = Integer.parseInt(st.nextToken());

            F f = null; //매 차례별 확률 누적값
            F pickWhite = new F(BigInteger.ONE, BigInteger.ONE); //빨간공 뽑기 직전까지의 확률(다음차례에 재활용)

            /*
                빨간 공 뽑는 경우 계산
                흰공 0개, 2개, 4개, ... 사용됨 -> 흰공 개수에 따라 계산해야 하는 경우의 수 정해짐
            */
            for(int white=0; white<=WHITE_BALLS/2*2; white+=2) {
                //흰공 확률
                int start = Math.max(0, white-2); // 사용된 흰공 0, 0~1, 2~3 구간별로 계산할 때 0에 대한 예외처리
                for(int usedW=start; usedW<white; usedW++) {
                    F whiteF = new F(BigInteger.valueOf(WHITE_BALLS - usedW), BigInteger.valueOf(RED_BALLS + WHITE_BALLS - usedW));
                    pickWhite = pickWhite.multiply(whiteF);
                }
                //빨간공 확률
                F redF = new F(BigInteger.valueOf(RED_BALLS), BigInteger.valueOf(RED_BALLS + WHITE_BALLS - white));
                if(f == null) f = new F(pickWhite.multiply(redF));
                else f = f.add(pickWhite.multiply(redF));
            }
            sb.append(f.print()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static class F {
        private BigInteger n; //분자
        private BigInteger d; //분모

        public F(BigInteger n, BigInteger d) {
            this.n = n;
            this.d = d;
        }

        public F(F f) {
            this.n = f.getN();
            this.d = f.getD();
        }

        public BigInteger getN() {
            return this.n;
        }
        public BigInteger getD() {
            return this.d;
        }
        public F add(F b) {
            //약분
            BigInteger gcd = this.d.gcd(b.getD());
            BigInteger lcm = this.d.multiply(b.getD().divide(gcd));
            BigInteger n = this.n.multiply(b.getD().divide(gcd)).add(b.getN().multiply(this.d.divide(gcd)));
            BigInteger d = lcm;
            gcd = n.gcd(d);
            if(gcd.compareTo(BigInteger.ONE) == 0) return new F(n, d);
            else return new F(n.divide(gcd), d.divide(gcd));
        }

        public F multiply(F b) {
            BigInteger n = this.n.multiply(b.getN());
            BigInteger d = this.d.multiply(b.getD());
            //약분
            BigInteger gcd = n.gcd(d);
            if(gcd.compareTo(BigInteger.ONE) == 0) return new F(n, d);
            else return new F(n.divide(gcd), d.divide(gcd));
        }

        public StringBuilder print() {
            StringBuilder sb = new StringBuilder();
            return sb.append(n).append('/').append(d);
        }
    }
}
