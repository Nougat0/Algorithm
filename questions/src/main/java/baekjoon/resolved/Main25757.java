package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main25757 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int recruit = 0, gamePlayedCnt = 0;
        Set<String> applied = new HashSet<>();
        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int needed = Game.getQuota(st.nextToken()) - 1; //본인 제외 필요인원
        for(int i=0; i<n; i++) {
            String name = br.readLine();
            //연산
            if(!applied.contains(name)) { //지원한 적 없을 경우
                applied.add(name); //지원자 명단에 추가
                if(++recruit == needed) { //모집인원+1, 모집인원 충원 완료 시
                    recruit = 0; //모집인원 초기화
                    gamePlayedCnt++; //게임 진행 횟수 증가
                }
            }
        }
        //출력
        bw.write(gamePlayedCnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 게임별 모집정원 표기용 enum 정의
     */
    enum Game {
        Y, F, O; //각 게임 약어 목록 (모집정원 순서대로 정렬됨)
        static int getQuota(String game) {
            return Game.valueOf(game).ordinal() + 2;
        }
    }
}
