package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main4137 {
    /*
        https://www.acmicpc.net/problem/4137
        https://www.acmicpc.net/user/bcdlife
    */
    public static final int ARRAY_LENGTH = 10_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] telephoneCount = new int[ARRAY_LENGTH];
        int min = ARRAY_LENGTH, max = 0; //최소최대 범위 추적
        while(n-- > 0) {
            StringBuilder telephoneNumber = new StringBuilder();
            char[] number = br.readLine().toCharArray();
            int length = number.length;
            for(int i=0; i<length; i++) {
                char letter = number[i];
                if(letter >= '0' && letter <= '9') {
                    telephoneNumber.append(letter);
                } else if(letter >= 'A' && letter <= 'Z') {
                    telephoneNumber.append(getNumberFromLetter(letter));
                }
            }
            int teleNumIntKey = Integer.parseInt(telephoneNumber.toString());
            telephoneCount[teleNumIntKey]++;
            if(teleNumIntKey > max) max = teleNumIntKey;
            if(teleNumIntKey < min) min = teleNumIntKey;
        }
        //lexicographical 정렬 (배열이라 자동)

        //중복 확인
        int duplicateCount = 0;
        for(int i=min; i<=max; i++) {
            int count = telephoneCount[i]; //개수 세기
            if(count > 1) {
                //7자리 고정 (3 - 4 자리)
                appendNumberAsLength(i / 10000, 3, sb);
                sb.append('-');
                appendNumberAsLength(i % 10000, 4, sb);
                sb.append(' ').append(count).append("\n");
                duplicateCount++;
            }
        }
        //출력
        if(duplicateCount == 0) {
            bw.write("No duplicates.");
        } else {
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 전화번호 숫자에 맵핑된 알파벳 규칙대로 번호 도출하기
     * @param letter 알파벳
     * @return 번호
     */
    public static int getNumberFromLetter(char letter) {
        if(letter >= 'S') letter--;
        return (letter - 'A')/3 + 2;
    }

    /**
     * 전달받은 StringBuilder 에 값을 넣어주기
     * 길이에 맞지 않을 경우 앞부분을 "0" 으로 채워준다
     * @param value
     * @param digit
     * @param sb
     */
    public static void appendNumberAsLength(int value, int digit, StringBuilder sb) {
        if(value == 0) {
            sb.append("0".repeat(digit));
        } else {
            int length = (int) Math.log10(value) + 1;
            if(length < digit) sb.append("0".repeat(digit - length));
            sb.append(value);
        }
    }
}
