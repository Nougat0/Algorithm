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
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int studentCnt = Integer.parseInt(st.nextToken());
        int endTime = Integer.parseInt(st.nextToken());
        int[] list = new int[studentCnt];
        for(int i=0; i<studentCnt; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        //폭죽 터뜨리기
        int fireworksShown = 0;
        for(int t=1; t<=endTime; t++) {
            //폭죽 터뜨린 사람 있는지 확인
            //있을 시, 체크 후 해당 시간 확인 중단
            for(int i=0; i<studentCnt; i++) {
                if(t % list[i] == 0) {
                    fireworksShown++;
                    break;
                }
            }
        }
        bw.write(fireworksShown + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
