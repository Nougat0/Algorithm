package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main30214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int halfSession = Integer.parseInt(st.nextToken()); //전반전에 문제 푼 사람 수
        int fullSession = Integer.parseInt(st.nextToken()); //대회 전체 참가자수
        bw.write(halfSession * 2 >= fullSession ? "E" : "H");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
