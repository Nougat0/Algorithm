package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main9784 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int i=1; i<=testCase; i++) {
            //입력값
            st = new StringTokenizer(br.readLine());
            int eggCnt = Integer.parseInt(st.nextToken());
            int riskyCnt = Integer.parseInt(st.nextToken());
            int capableGrams = Integer.parseInt(st.nextToken());
            Pot pot = new Pot(riskyCnt, capableGrams);
            //달걀 무게별 개수 파악
            int[] grams = new int[10]; //0~9 => 1~10
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                grams[Integer.parseInt(st.nextToken()) - 1]++;
            }
            //냄비에 달걀 담기
            potIsFull:
            for(int j=0; j<10; j++) {
                int gramsCount = grams[j]; //(j+1)gram인 계란의 수
                if(gramsCount > 0) {
                    //냄비에 담기 시도
                    for(int k=1; k<=gramsCount; k++) {
                        boolean success = pot.addEgg(j+1);
                        if(!success) break potIsFull;
                    }
                }
            }
            //결과 출력
            sb.append("Case ").append(i).append(": ").append(pot.eggCnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 냄비 객체 클래스
     */
    public static class Pot {
        int eggCnt; //담긴 달걀 개수
        int eggGrams; //담긴 달걀 그람수
        int maxCnt; //달걀 개수 최대값 (초과 불가)
        int capacity; //그람수 최대값 (초과 불가)

        public Pot(int riskyCnt, int capacity) {
            this.maxCnt = riskyCnt;
            this.capacity = capacity;
            this.eggCnt = 0;
            this.eggGrams = 0;
        }

        /**
         * 달걀 냄비에 담기
         * @param weight
         * @return 성공 여부 반환
         */
        public boolean addEgg(int weight) {
            boolean available = eggCnt < maxCnt && (capacity - eggGrams) >= weight;
            if(available) {
                eggCnt++;
                eggGrams += weight;
            }
            return available;
        }
    }
}
