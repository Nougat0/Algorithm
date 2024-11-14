package baekjoon.resolved;

import java.io.*;

public class Main27389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //메트로놈 1바퀴 감을 때마다 4번 틱 -> 1번 틱 = 0.25바퀴 감기
        int n = Integer.parseInt(br.readLine());
        double keyTurns = n * 0.25;
        bw.write(String.format("%.2f%n", keyTurns));
        bw.flush();
        bw.close();
        br.close();
    }
}
