package baekjoon.resolved;

import java.io.*;

public class Main1964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        long sum = 5; //초기값 1도형 지정
        for(int i=2; i<=n; i++) { //단계별 i도형 덧셈
            sum += i * 5 - (2 * i - 1);
        }
        bw.write(sum % 45678 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
