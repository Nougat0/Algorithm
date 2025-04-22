package baekjoon.resolved;

import java.io.*;

public class Main20492 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        final int PRIZE = Integer.parseInt(br.readLine());
        sb.append(PRIZE * 78 / 100)
                .append(' ')
                .append(PRIZE - PRIZE * 1 * 22 / 5 / 100);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
