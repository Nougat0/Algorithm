package baekjoon.resolved;

import java.io.*;

public class Main15727 {
    /*
        https://www.acmicpc.net/problem/15727
        https://www.acmicpc.net/user/bcdlife
    */
    public static final int SPEED = 5; //1~5중 하나 선택
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int distance = Integer.parseInt(br.readLine());
        int share = distance / SPEED;
        int remainder = distance % SPEED;
        int time = share + (remainder == 0 ? 0 : 1);
        bw.write(time + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
