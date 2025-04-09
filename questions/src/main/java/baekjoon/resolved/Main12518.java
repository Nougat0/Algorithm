package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main12518 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        String kingdomName;
        for(int i=1; i<=testCase; i++) {
            kingdomName = br.readLine();

            sb.append("Case #").append(i).append(": ").append(kingdomName);
            sb.append(" is ruled by ");

            switch(getLastLetter(kingdomName)) {
                case 'a': case 'e': case 'i': case 'o': case 'u':
                    sb.append("a queen");
                    break;
                case 'y':
                    sb.append("nobody");
                    break;
                default:
                    sb.append("a king");
            }
            sb.append(".\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 왕국 이름의 마지막 문자(알파벳 소문자)를 반환
     * 단어 길이가 1일 경우 대문자이므로 소문자로 바꿔서 반환
     * @param kingdomName {string}
     * @return {char}
     */
    public static char getLastLetter(String kingdomName) {
        int length = kingdomName.length();
        char lastLetter = kingdomName.charAt(length - 1);
        if(lastLetter < 97) lastLetter += 32; //한 자리라 대문자일 경우
        return lastLetter;
    }
}
