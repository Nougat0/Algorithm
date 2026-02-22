package baekjoon.resolved;

import java.io.*;

public class Main3578 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/3578
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        /**
         * 출력할 숫자의 개수는 최소한으로
         * 더 작은 숫자를 더 앞으로 나열
         */
        switch(n) {
            case 0: sb.append(1); break;
            case 1: sb.append(0); break;
            default:
                if(n % 2 == 1) sb.append(4);
                for(int i=0; i<n/2; i++) sb.append(8);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
