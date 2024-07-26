package baekjoon.resolved;

import java.io.*;

public class Main1769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] numbers = br.readLine().toCharArray();
        int count = 0; //문제2 변경 횟수
        long sum; //문제2 변경 결과

        while(numbers.length > 1) { //문제2 변경
            count++;
            sum = 0;
            for (char number : numbers) //각 자릿수 더하기
                sum += Character.getNumericValue(number);
            numbers = String.valueOf(sum).toCharArray();
        }
        //1의 자릿수 값 구하기
        sum = Character.getNumericValue(numbers[0]);

        bw.write(String.format("%d%n%s%n", count, sum%3 ==0 ? "YES" : "NO"));
        bw.flush();
        bw.close();
        br.close();
    }
}
