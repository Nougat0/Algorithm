package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main6840 {
    /*
    엄마곰의 그릇(중앙값) 찾기
     */
    public static final int BOWLS = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력 + 바로 연산
        int[] bowls = new int[BOWLS];
        int biggest = 0, smallest = 0, middle = 0;
        //단순 정렬보다 재밌어 보여서 해봤는데... 실효성은 없는 듯?
        for(int i=0; i<BOWLS; i++) {
            bowls[i] = Integer.parseInt(br.readLine());
            if(biggest == 0 && smallest == 0) {
                //초기값 지정
                biggest = bowls[i];
                middle = bowls[i];
                smallest = bowls[i];
            } else if(bowls[i] > biggest) {
                if(middle != biggest) middle = biggest; //밀기
                biggest = bowls[i];
            } else if(bowls[i] < smallest) {
                if(middle != smallest) middle = smallest; //밀기
                smallest = bowls[i];
            } else {
                middle = bowls[i];
            }
        }
        bw.write(middle + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
