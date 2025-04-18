package baekjoon.resolved;

import java.io.*;

public class Main2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = 7;
        boolean oddNumberExist = false;
        int minOdd = 99;
        int oddSum = 0;
        while(count-- > 0) {
            int number = Integer.parseInt(br.readLine());
            boolean isOdd = number % 2 == 1;
            if(isOdd) {
                oddNumberExist = true;
                oddSum += number;
                if(number < minOdd) {
                    minOdd = number;
                }
            }
        }
        if(oddNumberExist) {
            bw.write(oddSum + "\n" + minOdd);
        } else {
            bw.write("-1");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
