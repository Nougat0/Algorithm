package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main30617 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int length = Integer.parseInt(br.readLine());
        int currL, currR, lastL=0, lastR=0;

        int fun = 0; //재미
        for(int t=0; t<length; t++) {
            st = new StringTokenizer(br.readLine());
            currL = Integer.parseInt(st.nextToken());
            currR = Integer.parseInt(st.nextToken());
            boolean moveL = (currL != 0);
            boolean moveR = (currR != 0);
            if(t > 0) { //[1] 이전과 같은 방향 노드
                if(moveL && lastL == currL) fun++;
                if(moveR && lastR == currR) fun++;
            }
            //[2] 양쪽 노드 같은 방향
            if(moveL && moveR && currL == currR) fun++;
            //현재 노드를 이전 노드 값으로 저장
            //int[length][2] 2중배열 대신 일반 int 변수 사용함
            lastL = currL;
            lastR = currR;
        }
        bw.write(fun + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
