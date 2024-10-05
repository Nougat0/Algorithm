package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main14467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력 + 연산
        int look = Integer.parseInt(br.readLine()); //관찰횟수
        int[] location = new int[10]; //소의 위치 기록
        boolean[] init = new boolean[10]; //소의 위치 최초관찰여부
        int crossed = 0; //소들이 길을 건넌 횟수 (통합)
        for(int i=0; i<look; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken()) - 1; //소
            int locate = Integer.parseInt(st.nextToken()); //위치
            if(init[index]) { //최초위치 관찰됨 -> 길 건넜는지 확인
                if(location[index] != locate) {
                    location[index] = locate;
                    crossed++;
                }
            } else { //최초위치 기록
                location[index] = locate;
                init[index] = true;
            }
        }
        //출력
        bw.write(crossed + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
