package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main4137 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> telephoneCount = new HashMap<>();
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
            telephoneCount.put(teleNumIntKey, telephoneCount.getOrDefault(teleNumIntKey, 0) + 1);
        }
        //lexicographical 정렬
        List<Integer> keySet = new ArrayList<>(telephoneCount.keySet());
        Collections.sort(keySet);
        //중복 확인
        int duplicateCount = 0;
        for(Integer teleNumIntKey : keySet) {
            int count = telephoneCount.get(teleNumIntKey); //개수 세기
            if(count > 1) {
                //7자리 고정 (3 - 4 자리)
                appendNumberAsLength(teleNumIntKey / 10000, 3, sb);
                sb.append('-');
                appendNumberAsLength(teleNumIntKey % 10000, 4, sb);
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
