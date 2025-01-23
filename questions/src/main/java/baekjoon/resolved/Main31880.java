package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main31880 {
    /*
    N의 값들이 0보다 같거나 큰 수이므로...
    그리디 알고리즘이라고는 하지만...
    무조건 N을 다 더하고 나서 M을 다 곱하는 게 이득이지 않은가?

    예외) M 중에서 0이 있다면 맨 처음에 곱해야 행운 손실이 없다
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int spellNCnt, spellMCnt, tempM;
        long luk = 0; //행운 초기값 0
        //개수 정보
        st = new StringTokenizer(br.readLine());
        spellNCnt = Integer.parseInt(st.nextToken());
        spellMCnt = Integer.parseInt(st.nextToken());
        //N 주문서
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<spellNCnt; i++) {
            luk += Integer.parseInt(st.nextToken());
        }
        //M 주문서
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<spellMCnt; i++) {
            tempM = Integer.parseInt(st.nextToken());
            //0인 값은 모두 맨 처음에 곱했다고 가정
            if(tempM > 0) luk *= tempM;
        }
        bw.write(luk + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
