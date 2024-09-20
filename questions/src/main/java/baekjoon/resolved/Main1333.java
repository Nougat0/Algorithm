package baekjoon.resolved;

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
        int listen = songCnt*(songLength + 5) + bellInterval;
        int songPlaying = 0, songInterval = 0;
        int songPlayed = 0;
        boolean playing = true;
        int firstHeard = -1;
        for(int i=0; i<listen; i++) {
            boolean bellRing = false;
            //벨소리 울리기 [1]
            if(i % bellInterval == 0) bellRing = true;
            //노래 듣기 [2]
            if(songPlayed == songCnt) {
                if(bellRing) {
                    firstHeard = i;
                    break;
                }
                continue;
            }
            if(playing) {
                if(songPlaying == songLength) {
                    playing = false;
                    songPlaying = 0;
                    songPlayed++;
                    songInterval++;
                } else
                    songPlaying++;
            } else {
                if(songInterval == 5){
                    playing = true;
                    songInterval = 0;
                    songPlaying++;
                } else
                    songInterval++;
            }
            //벨소리 들은 최초구간 찾기
            if(bellRing && !playing) {
                firstHeard = i;
                break;
            }
        }

//        //벨소리 들은 최초구간 찾기
//        for(int i=0; i<listen.length; i++) {
//            if(listen[i] == 1) {
//                firstHeard = i;
//                break;
//            }
//        }
        //출력
        bw.write(firstHeard + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
