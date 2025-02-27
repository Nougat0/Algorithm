package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main15886 {
    /*
    EW 가 기본적으로 반복되는 패턴
    ...EEEEWWWW... 도 마찬가지로 같은 패턴의 연장선
    따라서 W -> E 넘어갈 때 새로운 패턴이 등장하는 것이지만
    마지막 패턴을 놓칠 수 있으므로 E -> W 부분을 대신 체크하기
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[] road = br.readLine().toCharArray();
        int gift = 0;
        /*지도에서 벗어날 일이 없다 = 좌측 끝은 E, 우측 끝은 W*/
        boolean wasE = true;
        for(int i=0; i<n; i++) {
            boolean nowE = road[i] == 'E';
            if(wasE && !nowE) { //E -> W 등장 체크
                gift++;
            }
            wasE = nowE;
        }
        bw.write(gift + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
