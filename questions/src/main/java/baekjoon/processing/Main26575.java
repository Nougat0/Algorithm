package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main26575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++) {
            //입력
            st = new StringTokenizer(br.readLine());
            int dogCnt = Integer.parseInt(st.nextToken());
            double foodPerDogInPounds = Double.parseDouble(st.nextToken());
            double foodPricePerPound = Double.parseDouble(st.nextToken());
            //연산 및 소수점 2자리까지 반올림
            bw.write(String.format("$%.2f%n", dogCnt*foodPerDogInPounds*foodPricePerPound));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
