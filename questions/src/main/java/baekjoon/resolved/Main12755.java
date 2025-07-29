package baekjoon.resolved;

import java.io.*;

public class Main12755 {
    /*
        https://www.acmicpc.net/problem/12755
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int index = 0; // 현재 위치
        int length = 0; // n 자릿수
        int lengthNumCount; // n 자릿수에서는 10^(length-1) * 9 개의 숫자가 존재

        while(true) {
            length++;
            lengthNumCount = (int) Math.pow(10, length-1) * 9;
            if(index + (lengthNumCount * length) < n) {
                index += (lengthNumCount * length);
            } else { //몇 개가 필요한지 확인
                int count = (n - index) / length;
                int remains = (n - index) % length;
                if(remains == 0) { //마지막 숫자의 마지막 decimal 필요
                    int number = (int) Math.pow(10, length-1) + count - 1;
                    sb.append(number % 10);
                } else { //다음 숫자의 remains decimal 필요
                    int number = (int) Math.pow(10, length-1) + count;
                    sb.append(number / ((int) Math.pow(10, length-remains)) % 10);
                }
                break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
