package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2520 {
    static final int[] onesForBase = new int[] {8,8,4,1,9}; //반죽 분량 나눌 숫자
    static final int[] onesForTop = new int[] {1,30,25,10}; //토핑 분량 나눌 숫자
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer base;
        StringTokenizer top;
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for(int t=0; t<testCase; t++) {
            br.readLine(); //빈 줄 넘기고 시작
            base = new StringTokenizer(br.readLine());
            top = new StringTokenizer(br.readLine());
            double[] baseArr = new double[5]; //8 8 4 1 9 => 16 개 분량 onesForBase
            int[] topArr = new int[4]; //1 30 25 10 => 각각 1개 분량 onesForTop
            double maxBase = Double.MAX_VALUE;
            //반죽 개수(16개 단위), 토핑 개수 확인
            for(int i=0; i<5; i++) {
                baseArr[i] = Double.parseDouble(base.nextToken()) / onesForBase[i];
                if(i<4) topArr[i] = Integer.parseInt(top.nextToken()) / onesForTop[i];
                //반죽 최대값 구하기 (가장 작은 값)
                if(baseArr[i] < maxBase) maxBase = baseArr[i];
            }
            //반죽 개수 최종값 확인
            maxBase = Math.floor(maxBase * 16);
            //반죽과 토핑 중 더 적은 것만큼 팬케이크 만들기 가능
            int totalTop = Arrays.stream(topArr).sum();
            int maxPancakes = (int) Math.min(maxBase, totalTop);
            //출력
            sb.append(maxPancakes).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
