package baekjoon.resolved;

import java.io.*;

public class Main17252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean isSamSamNumber = true;
        int number = Integer.parseInt(br.readLine());
        //3진수로 변환했을 때 각 자리수에 1보다 큰 수(2번 사용됨)가 있을 경우 삼삼하지 않다.
        //반대로, 전부 0이거나 1이면 삼삼한 수
        if(number == 0) isSamSamNumber = false; //0 예외처리
        else {
            char[] reformatNumber = Integer.toString(number, 3).toCharArray();
            for(char digit: reformatNumber)
                if(Character.getNumericValue(digit) > 1) {
                    isSamSamNumber = false;
                    break;
                }
        }
        bw.write(isSamSamNumber ? "YES" : "NO");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
