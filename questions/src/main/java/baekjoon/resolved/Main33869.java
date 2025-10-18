package baekjoon.resolved;

import java.io.*;

public class Main33869 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/33869
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String wordForCode = br.readLine();
        int wordLength = wordForCode.length();
        int wordIndex;
        int codeIndex = 0;
        char[] codeTable = new char[26];
        boolean[] usedLetters = new boolean[26];
        for(wordIndex=0; wordIndex<wordLength; wordIndex++) {
            //중복 등장 케이스 제거
            while(wordIndex<wordLength && usedLetters[wordForCode.charAt(wordIndex) - 'A']) wordIndex++;
            if(wordIndex >= wordLength) break;
            char c = wordForCode.charAt(wordIndex);
            codeTable[codeIndex++] = c;
            usedLetters[c - 'A'] = true;
        }
        //남은 암호 테이블 채우기
        for(int i=0; i<26; i++) {
            //사용된 알파벳 제거
            while(i<26 && usedLetters[i]) i++;
            if(i >= 26) break;
            codeTable[codeIndex++] = (char) (i + 'A');
        }
        //암호화
        String str = br.readLine();
        int strLength = str.length();
        for(int i=0; i<strLength; i++) {
            int index = str.charAt(i) - 'A';
            sb.append(codeTable[index]);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
