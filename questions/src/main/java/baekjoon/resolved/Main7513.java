package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main7513 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/7513
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int t=1; t<=testCase; t++) {
            sb.append("Scenario #").append(t).append(":\n");
            int w = Integer.parseInt(br.readLine());
            String[] word = new String[w];
            for(int i=0; i<w; i++) {
                word[i] = br.readLine();
            }
            int people = Integer.parseInt(br.readLine());
            for(int p=1; p<=people; p++) {
                st = new StringTokenizer(br.readLine());
                int count = Integer.parseInt(st.nextToken());
                for(int c=0; c<count; c++) {
                    int index = Integer.parseInt(st.nextToken());
                    sb.append(word[index]);
                }
                sb.append("\n");
            }
            if(t < testCase) sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
