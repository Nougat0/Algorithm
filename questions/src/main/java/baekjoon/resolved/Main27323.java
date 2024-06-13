package baekjoon.resolved;

import java.io.*;

public class Main27323 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        bw.write(String.format("%d%n", a*b));
        bw.flush();
        bw.close();
        br.close();
    }
}
