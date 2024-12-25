package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main30569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        double[][] info = new double[2][3]; //체력, 화력, 재장전 시간
        //입력
        for(int i=0; i<2; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //초기화
        Player player1 = new Player(info[0][0], info[1][1], info[1][2]);
        Player player2 = new Player(info[1][0], info[0][1], info[0][2]);
        //연산
        player1.calculateDeath();
        player2.calculateDeath();
        //출력
        if(player1.aliveTime == player2.aliveTime) bw.write("draw");
        else if(player1.aliveTime > player2.aliveTime) bw.write("player one");
        else bw.write("player two");
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Player {
        double health; //체력
        double playTime; //플레이타임
        double enemyDamage; //적팀의 화력
        double enemyReload; //적팀의 재장전 시간
        double aliveTime; //살아있는 시간

        public Player(double health, double enemyDamage, double enemyReload) {
            this.playTime = 0;
            this.health = health;
            this.enemyDamage = enemyDamage;
            this.enemyReload = enemyReload;
        }

        /**
         * 사망시각 계산
         * 0.5초 후 첫 데미지 받음,
         * 쏘자마자 재장전하므로 초기 0.5초 딜레이가 계속 이어짐
         * (추가 딜레이 불필요)
         */
        public void calculateDeath() {
            //첫 타격
            playTime += 0.5;
            health -= enemyDamage;
            while(health > 0) {
                //재장전 후 타격
                playTime += enemyReload;
                health -= enemyDamage;
            }
            aliveTime = playTime;
        }
    }
}
