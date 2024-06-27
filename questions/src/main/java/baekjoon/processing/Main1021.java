package baekjoon.processing;

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
            while(que.get(pointer) != nextTarget) {
                if (que.get(pointer) < nextTarget) {
                    pointer++;
                } else if (que.get(pointer) > nextTarget) {
                    pointer--;
                }
                moves++;
            }
            que.remove(pointer);
            if(que.size() == pointer) pointer = 0;
        }

        bw.write(moves+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
