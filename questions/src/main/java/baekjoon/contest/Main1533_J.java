package baekjoon.contest;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main1533_J {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/contest/problem/1533/10
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        final int Q = Integer.parseInt(br.readLine());
        boolean[] tree = new boolean[Integer.MAX_VALUE];
        StringTokenizer st;
        for(int nights=1; nights<=Q; nights++) {
            st = new StringTokenizer(br.readLine());
            final int P = Integer.parseInt(st.nextToken());
            final int D = Integer.parseInt(st.nextToken());
            //레몬이 열림 - 재귀로 해결?
            for(int i=1; i<=D; i++) {
                //다음 간선 확인 - 길이 확인 - 열리게 함

            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
