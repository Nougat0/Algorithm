package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main10474 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            int numerator = Integer.parseInt(st.nextToken()); //분자
            int denominator = Integer.parseInt(st.nextToken()); //분모
            if(numerator == 0 && denominator == 0) {
                break; //테스트 종료
            }
            //분자나 분모는 0으로 입력되지 않음! 관련 예외처리 불필요
            int value = numerator / denominator; //정수부
            int newNumerator = numerator % denominator; //변경된 분자
            sb.append(value).append(' ').append(newNumerator).append(" / ").append(denominator);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
