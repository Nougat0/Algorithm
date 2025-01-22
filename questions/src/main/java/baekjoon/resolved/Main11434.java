package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main11434 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int items, wp, ep; //통합할 분야 수, 각 나라 인구수
        int ww, we, ew, ee; //두 나라 간의 선호도
        long dataSet = Long.parseLong(br.readLine());
        for(int t=1; t<=dataSet; t++) {
            st = new StringTokenizer(br.readLine());
            items = Integer.parseInt(st.nextToken());
            wp = Integer.parseInt(st.nextToken());
            ep = Integer.parseInt(st.nextToken());
            long happiness = 0; //행복 총량
            for(int i=0; i<items; i++) {
                st = new StringTokenizer(br.readLine());
                ww = Integer.parseInt(st.nextToken());
                we = Integer.parseInt(st.nextToken());
                ew = Integer.parseInt(st.nextToken());
                ee = Integer.parseInt(st.nextToken());
                //w, e 선택 시 행복 총량 비교하여 큰 것 선택
                happiness += Math.max(wp*ww + ep*ew, wp*we + ep*ee);
            }
            sb.append("Data Set ").append(t).append(":\n").append(happiness);
            if(t < dataSet) sb.append("\n\n"); //빈 줄로 구분
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
