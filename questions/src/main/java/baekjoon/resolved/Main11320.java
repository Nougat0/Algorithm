package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main11320 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int t=0; t<testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int lines = a/b;
            //0 ~ (lines-1) 까지니 lines-1 에 대한 값 구하기
            int n = lines-1;
            //각 줄마다 삼각형의 개수는 1+(line-1)*2 개,,, 1~N까지의 합 구하는 공식 사용
            int count = lines + (lines == 1 ? 0 : ((n+1)*(n/2) + (n%2 == 0 ? 0 : (n+1)/2)) * 2);
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
