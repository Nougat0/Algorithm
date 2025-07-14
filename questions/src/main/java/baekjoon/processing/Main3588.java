package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main3588 {
    /*
        https://www.acmicpc.net/problem/3588
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        final int DATA_SETS = Integer.parseInt(br.readLine());
        for(int dataSet=1; dataSet<=DATA_SETS; dataSet++) {
            int breaks = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            long gallonsWasted = 0;
            while(breaks-- > 0) {
                st = new StringTokenizer(br.readLine());
                int start = Math.max(s, Integer.parseInt(st.nextToken())); //더 나중 시작점 선택
                int finish = Math.min(f, Integer.parseInt(st.nextToken())); //더 이른 종료점 선택
                int rate = Integer.parseInt(st.nextToken());
                gallonsWasted += (finish - start + 1) * rate;
            }
            sb.append("Data Set ").append(dataSet).append(":\n").append(gallonsWasted);
            if(dataSet < DATA_SETS) sb.append("\n\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
