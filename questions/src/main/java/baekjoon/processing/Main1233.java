package baekjoon.processing;

import java.io.*;
import java.util.StringTokenizer;

public class Main1233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //주사위 3개 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        int s3 = Integer.parseInt(st.nextToken());
        //3면 합계 - 모든 경우의 수 집계
        int[] sumRate = new int[s1+s2+s3+1];
        for(int i=1; i<=s1; i++)
            for(int j=1; j<=s2; j++)
                for(int k=1; k<=s3; k++)
                    sumRate[i+j+k]++;
        //최대빈도수 합계 구하기 (일치할 경우 가장 작은 합계 사용)
        int maxSum = 0, maxSumRate = 0;
        for(int i=3; i<sumRate.length; i++)
            if(sumRate[i] > maxSumRate) {
                maxSumRate = sumRate[i];
                maxSum = i;
            }
        bw.write(maxSum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
