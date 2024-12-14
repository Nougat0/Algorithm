package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main6368 {
    static String[] morse = {
        ".-","-...","-.-.","-..", //A B C D
        ".","..-.","--.","....", //E F G H
        "..",".---","-.-",".-..", //I J K L
        "--","-.","---",".--.", //M N O P
        "--.-",".-.","...","-", //Q R S T
        "..-","...-",".--","-..-", //U V W Y
        "-.--","--..", //X Z
        "..--","---.",".-.-","----" // _ . , ?
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
        StringBuilder numberLine;
        StringBuilder code;
        int messages = Integer.parseInt(br.readLine());
        //테스트케이스
        for(int i=0; i<messages; i++) {
            result.append(i+1).append(": "); //Prefix
            numberLine = new StringBuilder();
            code = new StringBuilder();

            char[] message = br.readLine().toCharArray();
            //[1] 모스부호로 encode
            for(char c: message) {
                encode(c, code, numberLine);
            }
            //[2] 숫자 역순으로 decode
            int start = 0;
            for(int j=numberLine.length()-1; j>=0; j--) {
                int length = Character.getNumericValue(numberLine.charAt(j));
                String character = code.substring(start, start+length);
                result.append(decode(character));
                start += length;
            }
            result.append("\n"); //Suffix
        }
        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 암호화 메소드
     * @param c 문자
     * @param codeLine 암호화 결과를 저장할 문자열
     * @param numberLine 암호화 결과의 길이를 저장할 문자열
     */
    private static void encode(char c, StringBuilder codeLine, StringBuilder numberLine) {
        if(c >= 65 && c <= 90) {
            codeLine.append(morse[c-65]);
            numberLine.append(morse[c-65].length());
        } else {
            switch(c) {
                case '_':
                    codeLine.append(morse[26]);
                    numberLine.append(morse[26].length());
                    break;
                case '.':
                    codeLine.append(morse[27]);
                    numberLine.append(morse[27].length());
                    break;
                case ',':
                    codeLine.append(morse[28]);
                    numberLine.append(morse[28].length());
                    break;
                case '?':
                    codeLine.append(morse[29]);
                    numberLine.append(morse[29].length());
                    break;
            }
        }
    }

    /**
     * 복호화 메소드 - Map 대신 사용해봄
     * @param code 암호
     * @return 문자
     */
    public static char decode(String code) {
        char[] encoded = code.toCharArray();
        int length = encoded.length;
        switch(length) {
            case 1:
                if(encoded[0] == '.') return 'E';
                else return 'T';
            case 2:
                if(encoded[0] == '.')
                    if(encoded[1] == '-') return 'A';
                    else return 'I';
                else
                    if(encoded[1] == '-') return 'M';
                    else return 'N';
            case 3:
                if(encoded[0] == '.')
                    if(encoded[1] == '.')
                        if(encoded[2] == '.') return 'S';
                        else return 'U';
                    else
                        if(encoded[2] == '.') return 'R';
                        else return 'W';
                else
                    if(encoded[1] == '.')
                        if(encoded[2] == '.') return 'D';
                        else return 'K';
                    else
                        if(encoded[2] == '.') return 'G';
                        else return 'O';
            case 4:
                if(encoded[0] == '.')
                    if(encoded[1] == '.')
                        if(encoded[2] == '.')
                            if(encoded[3] == '.') return 'H';
                            else return 'V';
                        else
                            if(encoded[3] == '.') return 'F';
                            else return '_';
                    else
                        if(encoded[2] == '.')
                            if(encoded[3] == '.') return 'L';
                            else return ',';
                        else
                            if(encoded[3] == '.') return 'P';
                            else return 'J';
                else
                    if(encoded[1] == '.')
                        if(encoded[2] == '.')
                            if(encoded[3] == '.') return 'B';
                            else return 'X';
                        else
                            if(encoded[3] == '.') return 'C';
                            else return 'Y';
                    else
                        if(encoded[2] == '.')
                            if(encoded[3] == '.') return 'Z';
                            else return 'Q';
                        else
                            if(encoded[3] == '.') return '.';
                            else return '?';
        }
        return '*'; //예외 발생
    }
}
