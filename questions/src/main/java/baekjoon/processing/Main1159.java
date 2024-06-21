package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력, 알파벳 개수 확인
        int n = Integer.parseInt(br.readLine()); //1~150
        int[] alphabet = new int[26]; //97~122
        for(int i=0; i<n; i++) {
            alphabet[(int) br.readLine().charAt(0) - 97] += 1;
        }

        //같은 성 5명이 있는지 확인, 결과 출력
        boolean withdraw = true;
        for(int i=0; i<26; i++) {
            if(alphabet[i] >= 5) {
                withdraw = false;
                bw.write((char) i+97);
            }
        }
        if(withdraw) bw.write("PREDAJA");

        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
