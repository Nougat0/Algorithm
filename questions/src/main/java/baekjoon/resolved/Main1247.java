package baekjoon.resolved;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main1247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<3; i++) { //3번의 TestCase
            int n = Integer.parseInt(br.readLine()); //이번 TestCase의 정수 갯수
            BigInteger sum = BigInteger.valueOf(0); //합산 0으로 초기화
            for(int j=0; j<n; j++) { //n개 모두 더하기!
                sum = sum.add(BigInteger.valueOf(Long.parseLong(br.readLine())));
            }
            int result = sum.compareTo(BigInteger.valueOf(0));
            //출력
            if(result == -1) bw.write("-");
            else if(result == 1) bw.write("+");
            else bw.write("0");

            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
