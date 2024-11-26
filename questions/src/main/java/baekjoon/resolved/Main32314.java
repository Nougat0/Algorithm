package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main32314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ampere = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double watt = Double.parseDouble(st.nextToken());
        int volt = Integer.parseInt(st.nextToken());
        bw.write((ampere <= watt/volt ? 1 : 0) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
