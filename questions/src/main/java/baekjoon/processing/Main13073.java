package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main13073 {
    /*
    S1: 처음 N개의 양수의 합
    S2: 처음 N개의 양의 홀수의 합
    S3: 처음 N개의 양의 짝수의 합
    
    first N... 이라는 표현을 한 번에 이해하지 못했는데
    작은 수(먼저 등장하는 수)부터 세라는 것이었다
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++) {
            int num = Integer.parseInt(br.readLine());
            /*
            1+2+3+...+num
                = (1+num)+(2+num-1)+(3+num-2) ...
                = (1+num) * (num/2)
                = (1+num)*num / 2
                (짝수일 때만 적용되는 건 줄 알았는데 홀수일 때도 된다니...)
            */
            int sum1 = num * (num + 1) / 2;
            /*
            1+3+5+...+N(num 번째 홀수)
                = (1+2*0)+(1+2*1)+(1+2*2)+...+(1+2*(num-1))
                = 1*num + 2*(num-1)*num/2
                = 1*num + (num-1)*num
                = num*num
            */
            int sum2 = num * num;
            /*
            2+4+6+...+N(num 번째 짝수)
                = 2*1 + 2*2 + 2*3 +...+ 2*num
                = 2*num*(num+1)/2
                = num*(num+1)
            */
            int sum3 = num * (num + 1);
            sb.append(sum1).append(' ').append(sum2).append(' ').append(sum3).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
