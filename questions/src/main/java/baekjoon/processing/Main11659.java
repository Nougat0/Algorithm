package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main11659 {
    /*
        https://www.acmicpc.net/problem/11659
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<n; index++) numbers[index] = Integer.parseInt(st.nextToken());

        for(int caseNo=0; caseNo<m; caseNo++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;
            int count = j - i + 1; //개수
            int sum = 0;
            for(int index=0; index<count/2; index++) { //앞부분 뒷부분 한꺼번에 더하기
                sum += (numbers[i + index] + numbers[j - index]);
            }
            if(count % 2 == 1) { //홀수 개수 빠진 값 추가
                sum += numbers[(i+j)/2];
            }
            sb.append(sum).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
