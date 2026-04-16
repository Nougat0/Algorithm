package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main18322 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/18322
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int currentLine = 0;
        for(int i=0; i<n; i++) {
            String letter = st.nextToken();
            int letterLength = letter.length();
            if(currentLine + letterLength <= k) {
                if(currentLine > 0) sb.append(" ");
                sb.append(letter);
                currentLine += letterLength;
            } else {
                sb.append("\n");
                sb.append(letter);
                currentLine = letterLength;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
