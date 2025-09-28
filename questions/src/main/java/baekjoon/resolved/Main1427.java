package baekjoon.resolved;

import java.io.*;

public class Main1427 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/1427
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[10]; // 0~9
        int divisor = 10;
        //숫자 분포 조사
        while(n / divisor > 0) {
            numbers[n % divisor]++;
            n /= divisor;
        }
        numbers[n % divisor]++; //마지막 숫자도 포함
        //출력
        for(int i=9; i>=0; i--) {
            int loops = numbers[i];
            for(int loop=0; loop<loops; loop++) {
                sb.append(i);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
