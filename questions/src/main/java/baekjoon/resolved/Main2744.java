package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        char[] word = br.readLine().toCharArray();
        for(char c : word) {
            if(c/97 > 0) { //소문자
                sb.append((char) (c-32));
            } else { //대문자
                sb.append((char) (c+32));
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
