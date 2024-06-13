package baekjoon.processing;

import java.io.*;
import java.util.StringTokenizer;

public class Main1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int primeCount = 0;
        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            boolean isPrime = true;
            for(int i=2; i<num; i++) {
                if(num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime && num != 1) primeCount++;
        }
        bw.write(String.format("%d%n", primeCount));
        bw.flush();
        bw.close();
        br.close();
    }
}
