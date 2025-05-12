package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main5554 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/5554
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int totalSeconds = 0;
        for(int i=0; i<4; i++) {
            totalSeconds += Integer.parseInt(br.readLine());
        }
        sb.append(totalSeconds / 60).append("\n").append(totalSeconds % 60);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
