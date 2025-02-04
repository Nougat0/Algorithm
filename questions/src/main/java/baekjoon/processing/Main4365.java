package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main4365 {
    /*
    입력된 셔플 순서는 부가적으로 주어진다... 무조건 입력순서대로 셔플한 것이 아님
     */
    public static final int FULL_DECK = 52;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int shuffles = Integer.parseInt(br.readLine()); //셔플 개수
        int[][] organizedShuffle = new int[shuffles][FULL_DECK]; //정렬된 셔플 저장용 배열
        Deck deck = new Deck(shuffles);
        //예제에는 1줄에 26개 숫자가 존재하나... 문제 조건으로는 명시되지 않음
        //셔플정보 입력받음
        int index = 0, shuffleCount = 0;
        for(int i=0; i<shuffles*2; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=index; j<index+FULL_DECK/2; j++) {
                deck.shuffle[shuffleCount][j] = Integer.parseInt(st.nextToken());
            }
            //인덱스 값 조정
            if(index == FULL_DECK/2) {
                index = 0;
                shuffleCount++;
            } else {
                index += 26;
            }
        }
        //셔플 순서대로 정렬
        for(int i=0; i<shuffles; i++) {
            int order = Integer.parseInt(br.readLine());
            organizedShuffle[order - 1] = deck.shuffle[i];
        }
        deck.shuffle = organizedShuffle;
        //셔플 진행, 출력
        for(int i=0; i<shuffles; i++) {
            sb.append(deck.shuffle()); //셔플 진행 후 결과 출력
            sb.append("\n"); //셔플 사이 공백
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 전체 카드 순서, 셔플 진행하는 클래스
     */
    public static class Deck {
        Card[] cards; //현재 카드 (52개)
        int[][] shuffle; //셔플 순서와 동작
        int shuffleTurn; //셔플 진행할 순번

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
         * @return 셔플 직후 카드 순서 toString()
         */
        public String shuffle() {
            int[] oneShuffle = shuffle[shuffleTurn++];
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
