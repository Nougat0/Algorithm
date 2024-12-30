package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2774 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        int number, beautyCnt; //아름다운지 체크할 수, 아름다움 지표값
        boolean[] beauty; //각 숫자 나왔는지 체크
        for(int i=0; i<testCase; i++) {
            number = Integer.parseInt(br.readLine());
            beauty = new boolean[10]; //0~9
            beautyCnt = 0;
            while(beautyCnt < 10 && number / 10 > 0) {
                if(!beauty[number % 10]) {
                    beauty[number % 10] = true;
                    beautyCnt++;
                }
                number /= 10;
            }
            if(beautyCnt < 10 && !beauty[number]) beautyCnt++;
            sb.append(beautyCnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
