package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main10798 {
    /*
        https://www.acmicpc.net/problem/10798
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/source/78634224
        2024.05.21
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[][] arr = new char[5][15]; //'0'으로 초기화됨

        //입력
        for(int i=0; i<5; i++) {
            char[] word = br.readLine().toCharArray();
            for(int j=0; j<word.length; j++) {
                arr[i][j] = word[j];
            }
            for(int j=word.length; j<15; j++) {
                // '0'이 문자열에 사용되고 있으므로 대체제 '!' 넣어서 빈칸 표시
                arr[i][j] = '!';
            }
        }

        //출력
        for(int i=0; i<15; i++) {
            for(int j=0; j<5; j++) {
                if(arr[j][i] != '!') {
                    bw.write(Character.toString(arr[j][i]));
                }
            }
        }
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
