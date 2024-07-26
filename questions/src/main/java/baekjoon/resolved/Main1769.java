package baekjoon.resolved;

import java.io.*;

public class Main1769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] numbers = br.readLine().toCharArray();
        int count = 0; //문제2 변경 횟수
        long sum; //문제2 변경 결과

        //1의 자릿수 입력 시 바로 반환
        if(numbers.length == 1) {
            sum = Character.getNumericValue(numbers[0]);
        } else {
            while(true) {
                count++;
                sum = 0;
                for (char number : numbers) //각 자릿수 더하기
                    sum += Character.getNumericValue(number);
                if (sum / 10 > 0) //10의 자리 이상
                    numbers = String.valueOf(sum).toCharArray();
                else //1의 자리 시 종료
                    break;
            }
        }

        bw.write(String.format("%d%n%s%n", count, sum%3 ==0 ? "YES" : "NO"));
        bw.flush();
        bw.close();
        br.close();
    }
}
