package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main4689 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String input;
        while((input = br.readLine()) != null) {
            String[] line = input.trim().split("\\s+");
            int number = parseToDecimal(line[0], Integer.parseInt(line[1]));
            String result = parseToRadix(number, Integer.parseInt(line[2]));
            if(result.length() > 7) {
                result = "ERROR";
            }
            sb.append(String.format("%7s", result)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * N진수를 10진수로 변환
     * @param number N진수
     * @param radix N
     * @return 10진수
     */
    public static int parseToDecimal(String number, int radix) {
        int length=number.length(), result=0;
        char[] line = number.toCharArray();
        for(int i=0; i<length; i++) {
            result += getNumericValue(line[length - 1 - i]) * pow(radix, i);
        }
        return result;
    }

    /**
     * 10진수를 N진수로 변환
     * @param number 10진수
     * @param radix N
     * @return N진수
     */
    public static String parseToRadix(int number, int radix) {
        StringBuilder result = new StringBuilder();
        while(number > 0) {
            int remainder = number % radix;
            if(remainder >= 10) { //알파벳 대문자
                result.append((char) (remainder + 55));
            } else { //숫자
                result.append(remainder);
            }
            number /= radix;
        }
        return result.reverse().toString();
    }

    /**
     * N제곱수 반환
     * @param number N제곱할 수
     * @param power N
     * @return N제곱수
     */
    public static int pow(int number, int power) {
        int result = 1;
        for(int i=0; i<power; i++) {
            result *= number;
        }
        return result;
    }

    /**
     * 숫자, 알파벳 char가 표현하는 숫자로 변경
     * @param a
     * @return
     */
    public static int getNumericValue(char a) {
        if(a >= 65) {
            return 10 + a - 65;
        } else {
            return a - 48;
        }
    }
}
