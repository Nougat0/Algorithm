package baekjoon.processing;

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
            BigInteger number = BigInteger.ONE;
            for(int i=1; i<=n; i++) {//팩토리얼 계산
                number = number.multiply(BigInteger.valueOf(i));
                while(number.remainder(BigInteger.TEN).compareTo(BigInteger.ZERO) == 0)
                    number = number.divide(BigInteger.TEN); //뒤에 붙은 0 제거
                number = number.remainder(BigInteger.valueOf(100000)); //10만까지 자르기
            }
            sb.append(" ".repeat(5-length)).append(n).append(" -> ").append(number.remainder(BigInteger.TEN)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
