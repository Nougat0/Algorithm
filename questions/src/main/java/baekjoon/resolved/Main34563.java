package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main34563 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34563
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            //단일 사각형에서는 커넥터가 최소 3개가 필요하다
            //서로 인접한 사각형에서는 공통 변에서 커넥터 하나씩 제외 가능
            //직접 그려보니 사각형 격자가 많아지더라도, 제일 바깥 사각형의 꼭지점 3군데와 그 사이를 모두 고정하면 된다!
            sb.append(n + m - 1).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
