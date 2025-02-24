package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1773 {
    /*
        원문에 명시된 바로는
        모든 폭죽은 0초에 처음 쏘아올리지만,
        폭죽의 관찰시간은 1~N 이라서 번역본에서는 생략된 듯

        근데 굳이 for문을 안 돌고 최소공배수 의 배수들을 빼면 되는 게 아닌가?
        → N의 크기가 커질수록 찾아야 하는 최소공배수도 중첩되어 많아짐...

        ----- 제출 후 비교 --------------------------------------------------------------
        + 내 방식 : studentCnt * endTime 번 loop (전체 탐색ㅎ...)
        + 다른 분 방식 (1) : studentCnt * 학생의 rate 배수 초 번 loop
        + 다른 분 방식 (2) : studentCnt * 학생의 rate 배수 초 번 loop (이미 등장한 수는 제외)
        * 참고한 백준 소스 :  (1) 87155731	dmsgml9903
                            (2) 86454674	hy8923
    */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int studentCnt = Integer.parseInt(st.nextToken());
        int endTime = Integer.parseInt(st.nextToken());
        int fireworksShown = 0;
        boolean[] time = new boolean[endTime+1];
        for(int i=0; i<studentCnt; i++) {
            int rate = Integer.parseInt(br.readLine());
            if(!time[rate]) { //첫번째 배수에서 이미 폭죽 터진 경우 제외
                int t = rate;
                while(t <= endTime) {
                    if(!time[t]) {
                        time[t] = true;
                        fireworksShown++; //새로운 표시마다 즉석 카운트
                    }
                    t += rate;
                }
            }
        }
        /*
            매 loop 에 추가되는 if문에 걸리는 시간 
            VS
            마지막 최종 endTime 횟수만큼의 추가적인 loop 1회에 걸리는 시간
        */
        bw.write(fireworksShown + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
