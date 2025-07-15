package baekjoon.resolved;

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
                int start = Integer.parseInt(st.nextToken());
                int finish = Integer.parseInt(st.nextToken());
                int rate = Integer.parseInt(st.nextToken());
                if(start <= f && finish >= s) { //집계 범위에 걸쳤는지 확인
                    gallonsWasted += (Math.min(finish, f) - Math.max(start, s) + 1) * rate;
                }
            }
            sb.append("Data Set ").append(dataSet).append(":\n").append(gallonsWasted).append("\n");
            if(dataSet < DATA_SETS) sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
