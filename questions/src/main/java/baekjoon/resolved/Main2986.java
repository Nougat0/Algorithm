package baekjoon.resolved;

import java.io.*;

public class Main2986 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2986
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        /**
            int counter = 0;
            for(int i=n-1; i>=1; i--) {
                counter++;
                if(n % i == 0) break;
            }

            1 ~ N-1 사이 숫자 중, N의 가장 큰 약수 구하기.
                N은 N*1 로 N의 약수이다.
                그 다음가는 가장 큰 약수(B)를 구하려면, 1 다음가는 가장 작은 약수(S)를 구하면된다
                B*S = N 이 되므로.
            +) 다음가는 큰 약수와 N의 거리 구하기
        */
        int s=2;
        while(s < n) {
            if(n % s == 0) break;
            s++;
        }
        int counter = n - n / s;
        System.out.println(n == 1 ? 0 : counter);
        br.close();
    }
}
