package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main1333 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int songCnt = Integer.parseInt(st.nextToken());
        int songLength = Integer.parseInt(st.nextToken());
        int bellInterval = Integer.parseInt(st.nextToken());
        //강토가 듣는 것 (0:없음, 1:벨소리, 2:음악)
        int[] listen = new int[songCnt*(songLength + 5) + bellInterval];
        int songPlaying = 0, songInterval = 0;
        int songPlayed = 0;
        boolean playing = true;
        int firstHeard = -1;
        for(int i=0; i<listen.length; i++) {
            //벨소리 울리기 [1]
            if(i % bellInterval == 0) listen[i] = 1;
            //노래 듣기 [2]
            if(songPlayed == songCnt) continue;
            if(playing) {
                if(songPlaying == songLength) {
                    playing = false;
                    songPlaying = 0;
                    songPlayed++;
                    songInterval++;
                } else {
                    songPlaying++;
                    listen[i] = 2;
                }
            } else {
                if(songInterval == 5){
                    playing = true;
                    songInterval = 0;
                    songPlaying++;
                    listen[i] = 2;
                } else
                    songInterval++;
            }
        }

        //벨소리 들은 최초구간 찾기
        for(int i=0; i<listen.length; i++) {
            if(listen[i] == 1) {
                firstHeard = i;
                break;
            }
        }
        //출력
        bw.write(firstHeard + "\n");
        bw.flush();
        bw.close();
        br.close();

        /*
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        boolean heardBell = false;

       int disturbTime = n*l + (n-1)*5;
       boolean[] arr = new boolean[disturbTime];
        /*
        노래 사이 5초 간격이 언제인지 계산,
        전화벨이 울리는 시간이 언제인지 계산,
        둘이 대조하기

        for(int i=0; i<n; i++) {
            for(int j=i*(l+5); j<(i+1)*(l+5)-1; j++) {
                //if()
            }
        } */
    }
}