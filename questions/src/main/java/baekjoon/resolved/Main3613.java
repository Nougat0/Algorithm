package baekjoon.resolved;

import java.io.*;

public class Main3613 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/3613
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String variable = br.readLine();

        /** Java, C++ 형식 파악
         *  1) Java: 대문자 포함
         *  2) C++: 언더바(_) 포함
         *  둘 다 가능: 모두 소문자
         *  둘 다 아님: 대문자+언더바, 첫 단어 대문자/언더바, 언더바 2개 연속, 마지막 단어 언더바
         */
        boolean isError = false;
        boolean hasCapitalCase = false;
        boolean hasUnderScore = false;

        int length = variable.length();
        char firstChar = variable.charAt(0);
        char lastChar = variable.charAt(length - 1);
        if(isCapitalCase(firstChar) || isUnderScore(firstChar) || isUnderScore(lastChar)) {
            isError = true;
        } else {
            sb.append(firstChar);
            for(int i=1; i<length; i++) {
                char c = variable.charAt(i);
                if(isCapitalCase(c)) {
                    hasCapitalCase = true;
                    sb.append('_').append(toggleCase(c));
                } else if(isUnderScore(c)) {
                    hasUnderScore = true;
                    char nextChar = variable.charAt(i+++1); //i++ + 1
                    if(nextChar == c || isCapitalCase(nextChar)) {
                        isError = true;
                        break;
                    }
                    sb.append(toggleCase(nextChar));
                } else {
                    sb.append(c);
                }
            }
        }
        //출력
        if(isError || (hasCapitalCase && hasUnderScore)) {
            System.out.println("Error!");
        } else {
            System.out.println(sb);
        }
        br.close();
    }

    private static boolean isCapitalCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private static boolean isUnderScore(char c) {
        return c == '_';
    }

    private static char toggleCase(char c) {
        if(isCapitalCase(c)) {
            return (char) (c - 'A' + 'a');
        } else {
            return (char) (c - 'a' + 'A');
        }
    }
}
