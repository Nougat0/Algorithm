package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main16360 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int words = Integer.parseInt(br.readLine());
        for(int w=0; w<words; w++) {
            sb.append(translate(br.readLine())).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * pseudo 라틴어로 번역
     * @param word 영어단어
     * @return pseudo-라틴어
     */
    public static String translate(String word) {
        char[] arr = word.toCharArray();
        int lastIndex = arr.length-1;
        switch(arr[lastIndex]) {
            case 'a':
            case 'o':
            case 'u':
                return word.concat("s");
            case 'l':
            case 'r':
            case 'v':
                return word.concat("es");
            case 't':
            case 'w':
                return word.concat("as");
            case 'y':
                word = word.substring(0, lastIndex).concat("i");
            case 'i':
                return word.concat("os");
            case 'e':
                if(arr[lastIndex-1] == 'n')
                    return word.substring(0, lastIndex-1).concat("anes");
                else
                    return word.concat("us");
            case 'n':
                return word.substring(0, lastIndex).concat("anes");
            default:
                return word.concat("us");
        }
    }
}
