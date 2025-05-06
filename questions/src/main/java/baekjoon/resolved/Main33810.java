package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main33810 {
    /*
        https://www.acmicpc.net/problem/33810
        https://www.acmicpc.net/user/bcdlife
    */
    public static final int LENGTH = 10;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] line = br.readLine().toCharArray();
        char[] origin = new char[] {'S', 'c', 'i', 'C', 'o', 'm', 'L', 'o', 'v', 'e'};
        int changedCount = 0;
        for(int i=0; i<LENGTH; i++) {
            if(origin[i] != line[i]) changedCount++;
        }
        bw.write(changedCount + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
