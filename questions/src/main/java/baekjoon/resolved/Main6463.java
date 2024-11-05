package baekjoon.resolved;

import java.io.*;
import java.math.BigInteger;

public class Main6463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            int length = String.valueOf(n).length();
            long number = 1;
            for(int i=1; i<=n; i++) {//팩토리얼 계산
                number *= i;
                while(number%10 == 0) number /= 10; //뒤에 붙은 0 제거
                number %= 100000; //10만까지 자르기
            }
            sb.append(" ".repeat(5-length)).append(n).append(" -> ").append(number%10).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
