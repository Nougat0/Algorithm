package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main18155 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/18155
    */
    public static char[] leet = new char[] {
        //문제에 명시되지 않은 leet 숫자는 그대로 표기
        'O', 'L', 'Z', 'E', '4', 'S', 'B', 'T', 'B', '9'
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<String> bad = new ArrayList<>();
        for(int i=0; i<n; i++) {
            bad.add(br.readLine());
        }

        for(int j=0; j<m; j++) {
            String word = br.readLine();
            boolean isValid = true;
            for(int i=0; i<n && isValid; i++) {
                String badWord = bad.get(i);
                isValid = !checkWordHavingBadWord(word, badWord);
            }
            sb.append(isValid ? "VALID" : "INVALID").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean checkWordHavingBadWord(String word, String badWord) {
        int wordLength = word.length();
        int length = badWord.length();
        int badWordIndex = 0;
        for(int i=0; i<wordLength && badWordIndex < length; i++) {
            char badWordFirstLetter = badWord.charAt(0);
            char letter = word.charAt(i);
            if(Character.isDigit(letter)) letter = leet[letter - '0'];

            if(letter == badWord.charAt(badWordIndex)) {
                badWordIndex++;
            } else if(letter == badWordFirstLetter) {
                badWordIndex = 1; //바로 시작할지도 모르니까
            } else {
                badWordIndex = 0;
            }
        }
        return badWordIndex == length;
    }
}
