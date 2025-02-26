package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main2775 {
    /*
        b가 작으면 탐색필요범위가 좁아지기 때문에 (전체탐색 X)
        보다 유리한 Top-Down 방식의 DP 사용
        TestCase가 얼마나 많을지 몰라서 확실하지는 않지만
    */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        APT apt = new APT();
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<testCase; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int r = apt.getResident(k, n);
            sb.append(r).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static class APT {
        int[][] residents; //거주민 table
        public APT() {
            this.residents = new int[15][15];
        }
        /**
         * DP :: Top-Down 방식 (재귀)
         * @param a
         * @param b
         * @return
         */
        public int getResident(int a, int b) {
            if(a == 0) return b;
            else if(residents[a][b] > 0) {
                return residents[a][b];
            } else {
                int sum = 0;
                for(int i=1; i<=b; i++) {
                    sum += getResident(a-1, b);
                }
                return (residents[a][b] = sum);
            }
        }

        /**
         * DP :: Bottom-Up 방식
         * @param a
         * @param b
         * @return
         */
        public void dpFunc(int a, int b) {
            for(int i=0; i<=a; i++) {
                for(int j=1; j<=b; j++) {
                    int sum = 0;
                    if(i == 0) sum = j;
                    else {
                        for(int k=1; k<=j; k++) {
                            //밑층 1~b호 사람들 집합
                            sum += residents[i-1][k];
                        }
                    }
                    residents[i][j] = sum;
                }
            }
        }

    }

}
