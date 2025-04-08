package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main7600 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        boolean isUpper, isLower;
        while(true) {
            char[] line = br.readLine().toCharArray();
            if(line.length == 1 && line[0] == '#') break;
            boolean[] alphabet = new boolean[26];
            int count = 0;
            for(char c : line) {
                isUpper = c >= 65 && c <= 90;
                isLower = c >= 97 && c <= 122;
                if(isLower || isUpper) {
                    if(isUpper) c -= 65;
                    else if(isLower) c-= 97;
                    if(!alphabet[c]) {
                        alphabet[c] = true;
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
