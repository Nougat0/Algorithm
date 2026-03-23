package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main35367 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/35367
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[] result = new char[c];
        for(int i=0; i<r; i++) {
            String line = br.readLine();
            for(int j=0; j<c; j++) {
                if(line.charAt(j) != '.') {
                    result[j] = line.charAt(j);
                }
            }
        }
        for(int j=0; j<c; j++) sb.append(result[j]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
