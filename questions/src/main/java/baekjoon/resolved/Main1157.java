package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1157 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/1157
        https://www.acmicpc.net/source/78308704
        2024.05.14
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();
        char[] arr = word.toCharArray();
        int[] alphabetCount = new int[26]; //65~90

        //단어에 사용된 알파벳 count
        for(int i=0; i<arr.length; i++) {
            alphabetCount[arr[i] - 65] += 1;
        }

        //count 최대값 구하기
        int maxCount = Arrays.stream(alphabetCount).max().getAsInt();
        //maxAlphabet 무엇인지 구하기
        int maxAlphabet = -1; //초기값 -1, 중복일 경우 -1
        for(int i=0; i<alphabetCount.length; i++) {
            if(alphabetCount[i] == maxCount && maxAlphabet == -1) {
                maxAlphabet = (i + 65); //해당 알파벳의 char 값 채움
            } else if(alphabetCount[i] == maxCount && maxAlphabet != -1) {
                maxAlphabet = -1; //중복되었음을 표시
                break;
            }
        }

        System.out.println(maxAlphabet == -1 ? "?" : (char) maxAlphabet);
        br.close();
    }
}
