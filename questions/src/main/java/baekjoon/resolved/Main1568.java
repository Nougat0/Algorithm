package baekjoon.resolved;

import java.io.*;

public class Main1568 {
    static final int initialNumber = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int birdOnTree = Integer.parseInt(br.readLine());
        int number = initialNumber;
        int seconds = 0;
        while(birdOnTree > 0) { //새가 남아있을 동안
            while(birdOnTree >= number) { //노래하는 수만큼 날아갈 수 있을 동안만
                birdOnTree -= number;
                number++;
                seconds++;
            }
            number = initialNumber;
        }
        bw.write(seconds + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
