package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1706 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/1706
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        char[][] crossword = new char[rows][cols];
        TreeSet<String> words = new TreeSet<>();
        //가로 단어 체크
        for(int i=0; i<rows; i++) {
            String line = br.readLine();
            StringBuilder word = new StringBuilder();
            for(int j=0; j<cols; j++) {
                char c = line.charAt(j);
                crossword[i][j] = c;
                if(c != '#') {
                    word.append(c);
                } else {
                    if(word.length() > 1) {
                        words.add(String.valueOf(word));
                    }
                    word = new StringBuilder();
                }
            }
            if(word.length() > 1) {
                words.add(String.valueOf(word));
            }
        }

        //세로 단어 체크
        for(int j=0; j<cols; j++) {
            StringBuilder word = new StringBuilder();
            for(int i=0; i<rows; i++) {
                char c = crossword[i][j];
                if(c != '#') {
                    word.append(c);
                } else {
                    if(word.length() > 1) {
                        words.add(String.valueOf(word));
                    }
                    word = new StringBuilder();
                }
            }
            if(word.length() > 1) {
                words.add(String.valueOf(word));
            }
        }
        bw.write(words.first());
        bw.flush();
        bw.close();
        br.close();
    }
}
