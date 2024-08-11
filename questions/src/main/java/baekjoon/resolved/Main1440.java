package baekjoon.resolved;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1440 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /*
        사실상 시 부분에 올 숫자만 제약사항이 있고, 그 외의 분, 초는 입력값 모든 범위가 유효함
        따라서 시가 될 수 있는지만 확인해서 count

        모든 숫자 자리 6곳에는 0~9까지의 숫자가 올 수 있음...
         */
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int count = 0;
        int[] time = new int[3];
        for(int i=0; i<3; i++) //입력
            time[i] = Integer.parseInt(st.nextToken());

        for(int h=0; h<3; h++) //h(시간)
            for(int m=0; m<3; m++) { //m(분)
                if(h==m) continue; //같은자리 조회 시 넘김
                for(int s=0; s<3; s++) { //s(초)
                    if(m==s || h==s) continue; //같은자리 조회 시 넘김
                    if(time[h] > 0 && time[h] <= 12 && time[m] < 60 && time[s] < 60) count++;
                }
            }

        //출력
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
