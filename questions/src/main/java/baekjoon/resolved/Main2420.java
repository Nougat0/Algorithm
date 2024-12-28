package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2420 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long seunghwan = Long.parseLong(st.nextToken());
        long kyuhyun = Long.parseLong(st.nextToken());
        bw.write(Math.abs(seunghwan-kyuhyun) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
