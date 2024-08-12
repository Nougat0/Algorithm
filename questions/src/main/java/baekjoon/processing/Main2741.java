package baekjoon.processing;

import java.io.*;

public class Main2741 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int num = 1;
        while(n >= num) {
            bw.write(num++ + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
