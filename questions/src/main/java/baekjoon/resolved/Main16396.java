package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main16396 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //연이은 좌표(정수) 2개 사이 길이 1의 막대들 추적
        //색칠된 곳 기록용
        boolean[] projection = new boolean[9999];
        int colored = 0;

        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); //시작 좌표
            int end = Integer.parseInt(st.nextToken()); //종료 좌표
            for(int j=start; j<end; j++) {
                if(!projection[j-1]) { //색칠되지 않은 곳일 경우
                    projection[j-1] = true; //색칠
                    colored++; //칸 개수 세기
                }
            }
        }
        bw.write(colored + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
