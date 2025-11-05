package baekjoon.processing;

import java.io.*;

public class Main25178 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/25178
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int[] vowel1 = new int[5];
        int[] vowel2 = new int[5];

        int length = Integer.parseInt(br.readLine());
        String word1 = br.readLine();
        String word2 = br.readLine();
        boolean affected = false;
        //첫글자, 마지막글자 체크
        if(word1.charAt(0) == word2.charAt(0) && word1.charAt(length-1) == word2.charAt(length-1)) {
            for(int i=0; i<length; i++) {
                char c1 = word1.charAt(i);
                char c2 = word2.charAt(i);
                //[+] 서로 다른 단어인지 체크
                if(c1 != c2) affected = true;
                //[+] 알파벳 모음 사용개수 체크
                //[+] 자음 문자열 짓기
                if(isVowel(c1)) vowel1[getIndex(c1)]++;
                else sb1.append(c1);
                if(isVowel(c2)) vowel2[getIndex(c2)]++;
                else sb2.append(c2);
            }

            //모음 제외한 문자열 비교
            int length1 = sb1.length();
            int length2 = sb2.length();
            if(length1 != length2) affected = false;

            if(affected) {
                //자음 문자열 체크
                for(int i=0; i<length1; i++) {
                    if(sb1.charAt(i) != sb2.charAt(i)) {
                        affected = false;
                        break;
                    }
                }
                //모음 사용개수 체크
                for(int i=0; i<5; i++) {
                    if(vowel1[i] != vowel2[i]) {
                        affected = false;
                        break;
                    }
                }
            }
        }
        bw.write(affected ? "YES" : "NO");
        bw.flush();
        bw.close();
        br.close();
    }

    //모음인지 체크
    public static boolean isVowel(char c) {
        switch(c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    //모음만 체크하기 위해 index 커스텀 지정하여 배열에서 사용
    public static int getIndex(char c) {
        switch(c) {
            case 'a': return 0;
            case 'e': return 1;
            case 'i': return 2;
            case 'o': return 3;
            case 'u': return 4;
            default: return -1;
        }
    }
}
