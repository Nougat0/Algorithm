package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main26021 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/26021
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String answer = br.readLine();
        int bridgeLength = Integer.parseInt(st.nextToken());
        int initialPlayers = Integer.parseInt(st.nextToken());

        Game game = new Game(answer, bridgeLength, initialPlayers);
        int result = game.process();
        System.out.println(result);
        br.close();
    }

    public static class Game {
        private static String answer;
        private static int length;
        private static int players;

        public Game(String answer, int length, int players) {
            this.answer = answer;
            this.length = length;
            this.players = players;
        }

        public static int process() {
            boolean leftTurn = true;
            for(int idx=0; idx<length && players>0; idx++) {
                char ans = answer.charAt(idx);
                boolean correct = !(leftTurn ^ (ans == 'L'));
                if(correct) {
                    leftTurn = !leftTurn; //반대 방향 선택
                } else {
                    players--; //이번 선택자 탈락
                }
            }
            return players;
        }
    }
}
