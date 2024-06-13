package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int primeSum = 0;

        List<Integer> prime = new ArrayList<>();
        for(int i=m; i<=n; i++) {
            if(i != 1 && checkIsPrime(i)) {
                prime.add(i);
                primeSum += i;
            };
        }

        //소수가 없을 경우 -1, 소수가 있을 경우 최소값 출력
        if(prime.isEmpty()) {
            bw.write(String.format("%d%n", -1));
        } else {
            bw.write(String.format("%d%n%d%n", primeSum, prime.get(0)));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 소수인지 확인하는 메소드
     */
    public static boolean checkIsPrime(int number) {
        for(int i=2; i<number; i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}