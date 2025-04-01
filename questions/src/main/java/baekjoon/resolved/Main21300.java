package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main21300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int refund = 0;
        while(st.hasMoreTokens()) {
            refund += Integer.parseInt(st.nextToken());
        }
        bw.write(refund*5 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
