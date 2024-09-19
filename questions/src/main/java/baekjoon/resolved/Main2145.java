package baekjoon.resolved;

import java.io.*;

public class Main2145 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = 0;
        while((testCase = Integer.parseInt(br.readLine())) != 0) {
            int sum = testCase;
            while(sum / 10 > 0) {
                sum = sumDigits(sum);
            }
            bw.write(sum + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int sumDigits (int testCase) {
        int sum = 0;
        while(testCase/10 > 0) {
            sum += testCase%10;
            testCase = testCase/10;
        }
        sum += testCase%10;
        return sum;
    }
}
