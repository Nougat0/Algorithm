package baekjoon.resolved;

import java.io.*;

public class Main24039 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/24039
    */
    public static boolean[] isNotPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        getPrime(n);

        int f=2, l=3, i=4;
        while(!(f*l > n)) {
            //다음 소수 찾기
            while(isNotPrime[i]) i++;
            //former/latter 갱신
            f = l;
            l = i;
            i++;
        }
        sb.append(f*l);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void getPrime(int n) {
        int length = n + 1;
        isNotPrime = new boolean[length];

        if(n < 2) return;
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for(int num=2; num <= Math.sqrt(n); num++) {
            if(isNotPrime[num]) continue;

            for(int i= num+num; i<length; i+=num) {
                isNotPrime[i] = true;
            }
        }
    }
}
