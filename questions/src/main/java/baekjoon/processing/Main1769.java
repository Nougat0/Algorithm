package baekjoon.processing;

import java.io.*;

public class Main1769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] numbers = br.readLine().toCharArray();
        int count = 0; //2번 변경 횟수
        long sum; //2번 변경 결과
        while(true) {
            sum = 0;
            for (char number : numbers) //각 자릿수 더하기
                sum += Character.getNumericValue(number);
            if (sum / 10 > 0) //10의 자리 이상
                numbers = String.valueOf(sum).toCharArray();
            else //1의 자리 시 종료
                break;
            count++;
        }
        bw.write(String.format("%d%n%s%n", count, sum%3 ==0 ? "YES" : "NO"));
        bw.flush();
        bw.close();
        br.close();
    }
}
