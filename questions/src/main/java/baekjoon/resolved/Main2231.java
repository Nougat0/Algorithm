package baekjoon.resolved;

import java.io.*;

public class Main2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int constructor = 0;

        for(int i=1; i<=n; i++) {
            if(getDisassemble(i) == n) {
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
     * @param n
     * @return
     */
    public static int getDisassemble(int n) {
        int disassemble = n;
        char[] digits = String.valueOf(n).toCharArray();
        for(char number: digits) {
            disassemble += Character.getNumericValue(number);
        }
        return disassemble;
    }
}
