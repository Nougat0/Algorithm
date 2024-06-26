package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] realDividers = new int[t];
        for(int i=0; i<t; i++) realDividers[i] = Integer.parseInt(st.nextToken());

        //진짜 약수들의 최소공배수 구하기 + 출력
        bw.write(getLeastCommonMultiple(realDividers)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 주어진 약수 목록의 최소공배수 구하기
     * @param realDividers 약수 목록
     * @return 약수 최소값 * 약수 최대값 (약수가 1개일 경우 해당 값의 제곱)
     */
    private static int getLeastCommonMultiple(int[] realDividers) {
        Arrays.sort(realDividers);
        return realDividers[0] * realDividers[realDividers.length-1];
    }
}
