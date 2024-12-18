package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main5101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] line = new int[3]; //첫 숫자, 간격, 체크할 값
        while(true) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<3; i++) line[i] = Integer.parseInt(st.nextToken());
            //종료조건 확인
            if(line[0] == 0 && line[1] == 0 && line[2] == 0) break;

            if((line[2] - line[0]) % line[1] == 0) {
                sb.append(((line[2] - line[0]) / line[1]) +1); //순번 출력
            } else {
                sb.append("X");
            }
            sb.append("\n");
        }
        //출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
