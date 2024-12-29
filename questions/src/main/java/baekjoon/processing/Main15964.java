package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main15964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long result = (a+b)*(a-b);
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
