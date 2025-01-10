package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main11916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int throwCnt = Integer.parseInt(br.readLine());
        StringTokenizer throwList = new StringTokenizer(br.readLine());
        Game game = new Game();
        while(throwList.hasMoreTokens()) {
            game.throwBall(Integer.parseInt(throwList.nextToken()));
        }
        bw.write(game.score + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    /*
        주자별로 볼 4번 카운트해야 함
    */
    public static class Game {
        int[] base = new int[3]; //1,2,3루
        int score = 0; //점수 (실점)
        int ballCount = 0; //볼 횟수

        /**
         * 공 던지기
         * @param ballType 공 종류
         * <br>1:볼, 2:데드볼, 3:폭투
         */
        void throwBall(int ballType) {
            //던진 공에 따른 볼 카운트 업데이트
            if(ballType != 2) ballCount++;
            //선수 위치 업데이트
            int[] newBase = new int[3];
            //[1] 타자 이동
            if(ballType == 2 || ballCount == 4) {
                newBase[0]++;
            }
            //[2-1] 기존 선수 이동 : 폭투
            if(ballType == 3) {
                //[*] 3루 선수
                score += base[2];
                //[*] 2루 선수
                newBase[2] += base[1];
                //[*] 1루 선수
                newBase[1] += base[0];
                base = newBase;
            }
            //[2-2] 기존 선수 이동 : 몸에 맞는 공 or 볼이면서 4볼 (폭투X)
            else if(ballType == 2 || (ballCount == 4 && ballType == 1)) {
                //[*] 3루 선수
                if(base[0] > 0 && base[1] > 0) score += base[2];
                else newBase[2] = base[2]; //제자리
                //[*] 2루 선수
                if(base[0] > 0) newBase[2] += base[1];
                else newBase[1] = base[1]; //제자리
                //[*] 1루 선수
                newBase[1] += base[0];
                base = newBase;
            }
            //볼 횟수 초기화
            if(ballType == 2 || ballCount == 4) ballCount = 0;
        }
    }
}
