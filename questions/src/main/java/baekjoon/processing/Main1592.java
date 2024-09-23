package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main1592 {
    static int peopleCnt; //총 인원
    static int ballMaxCatch; //한 사람이 공 받을 수 있는 최대횟수
    static int tossLocation; //공을 던질 다음 위치 (상대적 거리)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        peopleCnt = Integer.parseInt(st.nextToken());
        ballMaxCatch = Integer.parseInt(st.nextToken());
        tossLocation = Integer.parseInt(st.nextToken());
        int[] ballCatchCnt = new int[peopleCnt];
        int totalBallCatch = 0;
        Integer catchNo = 0;
        while((catchNo = ballToss(catchNo, ballCatchCnt)) != null)
            totalBallCatch++;

        bw.write(totalBallCatch + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 다음 사람한테 공을 던지고, 받은 횟수 카운팅 해주는 메소드
     * @param catchNo
     * @param ballCatchCnt
     * @return Integer 다음 공을 받을 사람 반환,
     * 경기가 끝나서 받을 사람이 없다면 null 반환
     */
    public static Integer ballToss(int catchNo, int[] ballCatchCnt) {
        ballCatchCnt[catchNo]++;
        if(ballCatchCnt[catchNo] == ballMaxCatch) return null; //게임 끝
        //다음 던질 대상
        if(ballCatchCnt[catchNo] % 2 == 0) { //짝수번 받았을 때 - 역방향
            catchNo -= tossLocation;
            if(catchNo < 0) catchNo += peopleCnt;
        } else { //홀수번 받았을 때 - 정방향
            catchNo += tossLocation;
            if(catchNo > peopleCnt-1) catchNo -= peopleCnt;
        }
        return catchNo;
    }
}
