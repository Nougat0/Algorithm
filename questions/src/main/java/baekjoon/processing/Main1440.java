package baekjoon.processing;

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

        //0번이 시
        if(time[0] > 0 && time[0] <= 12) {
            //분, 초 체크
            if(time[1] < 60 && time[2] < 60) count++;
            if(time[2] < 60 && time[1] < 60) count++;
        }
        //1번이 시
        if(time[1] > 0 && time[1] <= 12) {
            //분, 초 체크
            if(time[0] < 60 && time[2] < 60) count++;
            if(time[2] < 60 && time[0] < 60) count++;
        }
        //2번이 시
        if(time[2] > 0 && time[2] <= 12) {
            //분, 초 체크
            if(time[1] < 60 && time[0] < 60) count++;
            if(time[0] < 60 && time[1] < 60) count++;
        }

        //출력
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
