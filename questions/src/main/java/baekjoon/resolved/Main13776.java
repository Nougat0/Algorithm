package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main13776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine()); //crossword 크기
        int assignNo = 1; //배정번호
        char[] line;
        int[] alphabet = new int[26]; //65~90 알파벳 값 배정(!=0) 확인용
        char[] order = new char[26]; //65~90 배정순서 미리저장용
        //입력 및 연산
        allAssigned:
        for(int i=0; i<size; i++) {
            line = br.readLine().toCharArray();
            for(int j=0; j<line.length; j++) {
                if(line[j] != ' ' && alphabet[line[j]-65] == 0) {
                    order[assignNo-1] = line[j];
                    alphabet[line[j]-65] = assignNo++;
                }
                //알파벳 전부 등장 시 loop 중단
                if(assignNo > 26) break allAssigned;
            }
        }
        //출력
        for(char c: order) sb.append(c);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
