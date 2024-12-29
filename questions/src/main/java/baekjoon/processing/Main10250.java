package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int row, col, number;
        int y, x;
        int testCase = Integer.parseInt(br.readLine());
        for(int t=0; t<testCase; t++) {
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            number = Integer.parseInt(st.nextToken());
            y = number % row;
            x = number / row +1;
            sb.append(y).append(x/10 > 0 ? x : "0"+x).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
