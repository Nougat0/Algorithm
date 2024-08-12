package baekjoon.processing;

import java.io.*;

public class Main2742 {
    /** 2741번의 반대 **/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int num = 1;
        while(n >= num) {
            bw.write(n-- + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
