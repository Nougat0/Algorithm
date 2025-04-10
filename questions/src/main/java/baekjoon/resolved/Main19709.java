package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main19709 {
    /*
    최대한 많은 학교에 런치박스를 배분해야 함
    i번째 학교에는 0개(안 줌) 혹은 k[i]개(요구치 전부 줌) 둘 중 하나를 선택
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalCnt = Integer.parseInt(st.nextToken());
        int orderCnt = Integer.parseInt(st.nextToken());
        int[] orders = new int[orderCnt];
        for(int i=0; i<orderCnt; i++) orders[i] = Integer.parseInt(br.readLine());
        Arrays.sort(orders); //오름차순 정렬
        int received = 0;
        for(int i=0; i<orderCnt && (totalCnt -= orders[i]) >= 0; i++) {
            received++;
        }
        bw.write(received + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
