package baekjoon.resolved;

import java.io.*;

public class Main28248 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int packages = Integer.parseInt(br.readLine()); //배달한 소포 수
        int collision = Integer.parseInt(br.readLine()); //충돌 수
        int score = packages*50 - collision*10 + (packages > collision ? 500 : 0);

        bw.write(score + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
