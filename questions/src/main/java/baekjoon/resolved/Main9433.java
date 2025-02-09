package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main9433 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        int[] villages;
        /*
            문제에서는 왼쪽 <- 오른쪽 방향을 요구하나,
            계산이 불편하여 왼쪽 -> 오른쪽 방향을 사용 (결국 똑같은 것 같긴 함)
         */
        for(int t=0; t<testCase; t++) {
            villages = new int[20];
            st = new StringTokenizer(br.readLine());
            for(int v=0; v<20; v++) {
                villages[19 - v] = Integer.parseInt(st.nextToken());
            }
            //마을 이동
            int shift = 0, village;
            for(int v=0; v<20; v++) {
                //각 마을 인구: 이동해 온 사람들 포함된 인구
                village = (villages[v] += shift/2);
                if(v < 19) { //마지막 마을이 아닐 경우 이동
                    boolean isEven = village % 2 == 0;
                    shift = isEven ? village : village-1; //이동할 인원
                    villages[v] -= shift; //다음마을로 이동
                }
            }
            //출력
            for(int v=0; v<20; v++) {
                sb.append(villages[19 - v]);
                if(v < 19) sb.append(' '); //마을 사이에 구분자 넣기
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
