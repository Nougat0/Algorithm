package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main4365 {
    /*
    일전에 문제를 완전히 잘못 이해하고 풀었음... 수정함

    입력: 1) 존재하는 셔플 정보 모음 -> 2) 진행하는 셔플 번호
    셔플 정보로 주어지는 Integer들은 한 줄에 개수 제한이 따로 없음! Integer 총 개수만 알 수 있음
    입력된 셔플 정보가 모두 사용되는 것도 아님!!
    셔플 진행 횟수는 명시되지 않음... EOF 감지로 예상하고 구현함
     */
    public static final int FULL_DECK = 52;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int shuffles = Integer.parseInt(br.readLine()); //셔플 정보 개수
        Deck deck = new Deck(shuffles);
        //예제에는 1줄에 26개 숫자가 존재하나... 문제 조건으로는 줄당 Integer 개수 제한이 명시되지 않음
        int index = 0;
        while(index < shuffles*FULL_DECK) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                deck.shuffle[index / FULL_DECK][index % FULL_DECK] = Integer.parseInt(st.nextToken());
                index++;
            }
        }
        //셔플 진행, 출력
        String shuffleNumber;
        boolean start = false;
        while((shuffleNumber = br.readLine()) != null) {
            if(!start) start = true; //첫 결과물 이후 공백 넣기
            else sb.append("\n"); //셔플 사이 공백
            //셔플 진행 후 결과 출력
            sb.append(deck.shuffle(Integer.parseInt(shuffleNumber)));
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 전체 카드 순서 저장, 셔플 진행하는 클래스
     */
    public static class Deck {
        Card[] cards; //현재 카드 (52개)
        int[][] shuffle; //셔플 순서와 동작

        public Deck(int shuffleCnt) {
            //카드 덱 초기화
            this.cards = new Card[FULL_DECK];
            for(int i=0; i<4; i++) {
                for(int j=0; j<13; j++) {
                    cards[(i*13) + j] = new Card(i, j);
                }
            }
            //셔플 배열 초기화
            this.shuffle = new int[shuffleCnt][FULL_DECK];
        }

        /**
         * 셔플 동작 1회 진행
         * @param order 입력된 셔플 종류들 중 진행할 셔플의 순서
         * @return 셔플 직후 카드 순서 toString()
         */
        public String shuffle(int order) {
            int[] oneShuffle = shuffle[order-1];
            Card[] shuffledCards = new Card[FULL_DECK];
            for(int j=0; j<FULL_DECK; j++) {
                shuffledCards[j] = cards[oneShuffle[j] - 1];
            }
            cards = shuffledCards; //셔플된 카드뭉치를 기존 것과 대체
            return toString();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(Card card : cards) {
                sb.append(card.toString()).append("\n");
            }
            return sb.toString();
        }
    }

    /**
     * 카드 정보, 출력 담당 클래스
     */
    public static class Card {
        int suit; //Clubs, Diamonds, Hearts, Spades
        int value; //2~10, Jack, Queen, King, Ace

        public Card(int suit, int value) {
            //순서로만 입력받고 인쇄 시 실제 값으로 변환
            this.suit = suit;
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            switch(value) {
                case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8:
                    sb.append(value+2); break;
                case 9: sb.append("Jack"); break;
                case 10: sb.append("Queen"); break;
                case 11: sb.append("King"); break;
                case 12: sb.append("Ace"); break;
            }
            sb.append(" of ");
            switch(suit) {
                case 0: sb.append("Clubs"); break;
                case 1: sb.append("Diamonds"); break;
                case 2: sb.append("Hearts"); break;
                case 3: sb.append("Spades"); break;
            }
            return sb.toString();
        }
    }
}
