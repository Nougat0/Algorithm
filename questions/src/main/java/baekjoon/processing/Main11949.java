package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main11949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int studentCnt = Integer.parseInt(st.nextToken());
        int maxCard = Integer.parseInt(st.nextToken()); //1 ~ maxCard

        Game game = new Game(studentCnt, maxCard);
        //학생의 번호(순서)와 번호표의 번호는 서로 다름
        for(int i=0; i<studentCnt; i++) { //번호표 값
            game.studentTickets[i] = Integer.parseInt(br.readLine());
        }
        String result = game.play();
        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Game {
        int studentCnt; //학생수
        int[] studentTickets; //학생이 들고 있는 번호표
        int maxCard; //카드 최대값

        public Game(int studentCnt, int maxCard) {
            this.studentCnt = studentCnt;
            this.studentTickets = new int[studentCnt];
            this.maxCard = maxCard;
        }

        /**
         * 게임 진행
         * @return String 게임 결과
         */
        public String play() {
            for(int c=1; c<=maxCard; c++) {
                for(int s=0; s<studentCnt-1; s++) {
                    if(studentTickets[s]%c > studentTickets[s+1]%c) {
                        //번호표 교환
                        int temp = studentTickets[s];
                        studentTickets[s] = studentTickets[s+1];
                        studentTickets[s+1] = temp;
                    }
                }
            }
            return this.toString();
        }

        /**
         * studentTickets 배열의 문자열 반환
         * @return String
         */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<studentCnt; i++) {
                sb.append(studentTickets[i]).append("\n");
            }
            return sb.toString();
        }
    }
}
