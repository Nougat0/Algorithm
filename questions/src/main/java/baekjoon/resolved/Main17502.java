package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main17502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int length = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();
        char letter = 'a'; //채워넣을 때 사용할 임의의 알파벳 소문자
        for(int i=0; i<length; i++) {
            //임의의 알파벳 소문자 초기화
            if(letter > 'z') letter = 'a';
            //빈자리 채워넣기
            if(str[i] == '?') {
                if(str[length - 1 - i] == '?') {
                    str[i] = letter;
                    str[length - 1 - i] = letter++;
                } else {
                    str[i] = str[length - 1 -i];
                }
            }
            //출력
            sb.append(str[i]);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
