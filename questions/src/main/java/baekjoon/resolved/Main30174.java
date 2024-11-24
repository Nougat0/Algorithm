package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main30174 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++) {
            long ways = Long.parseLong(br.readLine());
            bw.write(ways + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
