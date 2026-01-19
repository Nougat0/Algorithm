package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main28419 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/28419
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long oddSum = 0;
        long evenSum = 0;
        for(int i=1; i<=n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if(i%2 == 0) evenSum += number;
            else oddSum += number;
        }

        long sum = 0;
        if(oddSum != evenSum) {
            if(n > 3) {
                //짝수 2개 지정, 홀수 2개 지정 둘 다 가능
                sum = Math.abs(oddSum - evenSum);
            } else if(oddSum < evenSum){
                //홀수 2개 지정 가능 + 짝수가 더 큰 상태
                sum = evenSum - oddSum;
            } else {
                //홀수 2개 지정 가능 + 짝수가 더 작은 상태
                sum = -1;
            }
        }
        sb.append(sum);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
