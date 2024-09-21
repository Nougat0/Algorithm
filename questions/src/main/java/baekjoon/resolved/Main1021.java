package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> que = new ArrayList<>();

        int pointer = 0; //안되겠음 index 를 사용해야 안 헷갈릴 듯
        int moves = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) que.add(i);

        for(int i=0; i<m; i++) {
            int nextTarget = Integer.parseInt(st.nextToken());
            int index = que.indexOf(nextTarget);

            //int straightMove = Math.abs(index - pointer);
            //int aroundMove = que.size() + straightMove;

            if(pointer != index) {
                //단순 크다 작다로 판단할 게 아니라 move 갯수를 확인하고 움직일 것
                if(pointer < index) {
                    if(index - pointer > pointer + que.size() - index) {
                        moves += pointer + que.size() - index;
                    } else {
                        moves += index - pointer;
                    }
                } else {
                    if(pointer - index > que.size() - pointer + index) {
                        moves += que.size() - pointer + index;
                    } else {
                        moves += pointer - index;
                    }
                }
                pointer = index;
            }
            que.remove(pointer);
            //마지막 index에 있었을 경우 0으로 이동
            if(que.size() == pointer) pointer = 0;
        }

        bw.write(moves+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
