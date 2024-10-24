package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main26550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for(int t=0; t<testCase; t++) {
            int layers = Integer.parseInt(br.readLine());
            long ornaments = 0;
            //레이어별 ornament 더하기
            for(long layer=1; layer<=layers; layer++) {
                //int 범위를 넘어가는 연산이 존재, long 타입의 index 변수 사용
                ornaments += (layers - (layer - 1)) * layer;
            }
            bw.write(ornaments + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
