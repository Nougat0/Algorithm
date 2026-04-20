package baekjoon.resolved;

import java.io.*;

public class Main2231 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2231
        https://www.acmicpc.net/source/79525029
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int constructor = 0;

        for(int i=1; i<=n; i++) {
            if(getDisassemble(i) == n) { //생성자 확인
                constructor = i;
                break;
            }
        }
        bw.write(String.format("%d%n", constructor));
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 분해합 구하기
     * @param n (생성자)
     * @return disassemble n의 분해합
     */
    public static int getDisassemble(int n) {
        int disassemble = n;
        while(n > 0) {
            disassemble += n % 10; //뒷자리부터 더하기
            n /= 10;
        }
        return disassemble;
    }
}
