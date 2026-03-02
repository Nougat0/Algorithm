package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main11945 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/11945
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[] mArr = new char[m];
        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=m-1; j>=0; j--) {
                mArr[j] = line.charAt(j);
            }
            for(int j=m-1; j>=0; j--) sb.append(mArr[j]);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
