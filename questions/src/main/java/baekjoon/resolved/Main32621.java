package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main32621 {
    /*
        in:
        첫 번째 줄에 길이 8 이하의 문자열이 주어진다.
        입력은 알파벳 대소문자, 숫자, '+'로만 이루어져 있다.

        + 양쪽 값이 N인 양의 정수일 때 isCute = true
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), "+");
        boolean isCute = false;
        if(st.countTokens() == 2) { //'+' 기준으로 앞뒤 2개 값 확인 ('+' 없을 시 1개)
            String a = st.nextToken();
            String b = st.nextToken();
            if(a.charAt(0) != '0' && checkNumeric(a) && a.equals(b)) {
                isCute = true;
            }
        }
        bw.write(isCute ? "CUTE" : "No Money");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 문자열이 숫자 형식인지 확인
     * @param str
     * @return
     */
    public static boolean checkNumeric(String str) {
        char[] array = str.toCharArray();
        for(char c : array) {
            if(c < 48 || c > 57) return false;
        }
        return true;
    }
}