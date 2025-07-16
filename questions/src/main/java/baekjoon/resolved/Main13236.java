package baekjoon.resolved;

import java.io.*;

public class Main13236 {
    /*
        https://www.acmicpc.net/problem/13236
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        bw.write(getSequence(n) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * collatz 시퀀스 구현
     * @param n
     * @return
     */
    public static StringBuilder getSequence(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n); //최초값 추가
        while(n != 1) {
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n = n*3 + 1;
            }
            sb.append(" ").append(n);
        }
        return sb;
    }
}
