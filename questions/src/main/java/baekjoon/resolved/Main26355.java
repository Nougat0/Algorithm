package baekjoon.resolved;

import java.io.*;

public class Main26355 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/26355
    */
    public static final int MAX = 101 * 101;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        boolean[] isNotPrime = new boolean[MAX];
        checkPrime(isNotPrime);

        while(n-- > 0) {
            int value = Integer.parseInt(br.readLine());
            sb.append("Input value: ").append(value).append("\n");
            if(isNotPrime[value]) {
                int missedUp = 1, missedDown = 1;
                while(isNotPrime[value + missedUp]) missedUp++;
                while(isNotPrime[value - missedDown]) missedDown++;
                sb.append("Missed it by that much (").append(Math.min(missedUp, missedDown)).append(")!");
            } else {
                sb.append("Would you believe it; it is a prime!");
            }
            if(n > 0) sb.append("\n\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void checkPrime(boolean[] isNotPrime) {
        int sqrt = (int) Math.sqrt(MAX);
        for(int i=2; i<sqrt; i++) {
            if(!isNotPrime[i]) {
                int j=2;
                while(i * j <= MAX) {
                    isNotPrime[i * j++] = true;
                }
            }
        }
    }
}
