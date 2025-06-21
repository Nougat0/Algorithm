package baekjoon.resolved;

import java.io.*;

public class Main2748 {
    /*
        https://www.acmicpc.net/problem/2748
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] fibo = new long[n+1];
        //미리 채워넣기
        fibo[0] = 0;
        fibo[1] = 1;
        //fibo[n] 밑에서부터 순차적으로 구하기
        for(int index=2; index<=n; index++) {
            fibo[index] = fibo[index-1] + fibo[index-2];
        }
        System.out.println(fibo[n]);
        br.close();
    }
}
