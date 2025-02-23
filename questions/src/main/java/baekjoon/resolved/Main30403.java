package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main30403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = Integer.parseInt(br.readLine());
        char[] line = br.readLine().toCharArray();
        Rainbow rainbow = new Rainbow();
        for(char c : line) {
            rainbow.checkInput(c);
        }
        bw.write(rainbow.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Rainbow {
        //이중배열 : 미사용 칸이 많아지지만 코드는 간편함
        boolean[][] rainbow; //등장한 무지개 알파벳 추적용 이중배열 (소문자, 대문자)
        int lowerCount; //등장한 무지개 알파벳 소문자 개수
        int upperCount; //등장한 무지개 알파벳 대문자 개수

        public Rainbow() {
            this.rainbow = new boolean[2][26];
            this.lowerCount = 0;
            this.upperCount = 0;
        }

        /**
         * 주어지는 문자가 무지개 알파벳과 연관있으면 count++
         * 아닐 시 아무 동작 없음
         * @param input 문자
         */
        public void checkInput(char input) {
            switch(input) {
                case 'r': case 'o': case 'y': case 'g': case 'b': case 'i': case 'v':
                    if(!rainbow[0][input-97]) {
                        rainbow[0][input-97] = true;
                        lowerCount++;
                    }
                    break;
                case 'R': case 'O': case 'Y': case 'G': case 'B': case 'I': case 'V':
                    if(!rainbow[1][input-65]) {
                        rainbow[1][input-65] = true;
                        upperCount++;
                    }
                    break;
                default:
            }
        }

        @Override
        public String toString() {
            boolean lowerOK = lowerCount == 7;
            boolean upperOK = upperCount == 7;
            if(lowerOK && upperOK) {
                return "YeS";
            } else if(lowerOK) {
                return "yes";
            } else if(upperOK) {
                return "YES";
            } else {
                return "NO!";
            }
        }
    }
}
