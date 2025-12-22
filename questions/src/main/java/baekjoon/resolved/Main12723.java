package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main12723 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/12723
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Integer[][] arr;
        int testCase = Integer.parseInt(br.readLine());
        for(int t=1; t<=testCase; t++) {
            int length = Integer.parseInt(br.readLine());
            arr = new Integer[2][length];
            for(int i=0; i<2; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<length; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //2가지 방식 모두 시도해봐야 함
            Arrays.sort(arr[0]);
            Arrays.sort(arr[1], Collections.reverseOrder());
            int resultA = 0;
            for(int i=0; i<length; i++) {
                resultA += arr[0][i] * arr[1][i];
            }
            int resultB = 0;
            for(int i=length-1; i>=0; i--) {
                resultB += arr[0][i] * arr[1][i];
            }
            sb.append("Case #").append(t).append(": ");
            sb.append(Math.min(resultA, resultB)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
