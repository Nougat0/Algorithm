package baekjoon.processing;

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
            String str = Integer.toString(number,b);
            if(isPalindrome(str)) return 1;
        }
        return 0;
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
