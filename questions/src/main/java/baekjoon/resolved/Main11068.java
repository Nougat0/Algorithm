package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main11068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for(int t=0; t<testCase; t++) {
            int number = Integer.parseInt(br.readLine());
            sb.append(checkPalindromeForRadixes(number)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 2~64진수에서 회문인 수 확인
     * @param number 10진수 숫자
     * @return 회문인 수: 1, 회문인 수가 아님: 0
     */
    public static int checkPalindromeForRadixes(int number) {
        for(int b=2; b<=64; b++) {
            String str = convertToRadix(number, b);
            if(isPalindrome(str)) return 1;
        }
        return 0;
    }

    /**
     * 10진수를 N진수로 변환
     * 각 나머지는 다음처럼 표기함.
     * 1) 0~9 : 0~9,
     * 2) 10~35 : a~z,
     * 3) 36~61 : A~Z,
     * 4) 62~64 : #,$,%
     * @param number N (2<= N <= 64)
     * @return 변환된 문자열
     */
    public static String convertToRadix(int number, int radix) {
        StringBuilder result = new StringBuilder();
        while(number > 0) {
            int remainder = number % radix;
            if(remainder >= 62) {
                result.append((char) (remainder - 62 + '#')); //#, $, %
            } else if(remainder >= 36) {
                result.append((char) (remainder - 37 + 'A')); //A~Z
            } else if(remainder >= 10) {
                result.append((char) (remainder - 10 + 'a')); //a~z
            } else {
                result.append(remainder); //0~9
            }
            number /= radix;
        }
        return result.toString();
    }

    /**
     * 회문인 문자열 확인
     * @param str 문자열
     * @return 회문인 문자열이 맞음: true, 아님: false
     */
    public static boolean isPalindrome(String str) {
        char[] arr = str.toCharArray();
        int length = arr.length;

        for(int i=0; i<length/2; i++)
            if(arr[i] != arr[length-1-i])
                return false;
        return true;
    }
}
