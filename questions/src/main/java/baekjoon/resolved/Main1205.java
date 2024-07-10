package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int currentScoreCnt = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int scoreMaxCnt = Integer.parseInt(st.nextToken());
        //노래방 랭킹 대시보드 구현체
        Dashboard dashboard = new Dashboard();
        //현재 등록된 점수 있을 시 추가
        if(currentScoreCnt > 0) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) dashboard.addScore(Integer.parseInt(st.nextToken()));
        }

        //출력 - 여기 있는 분기처리 로직 Dashboard로 옮기면 좋을텐데...
        if(dashboard.getNewScoreNo(newScore) <= scoreMaxCnt)
            bw.write(dashboard.getNewScoreRank(newScore) + "\n");
        else
            bw.write(-1 + "\n");
        bw.flush();
        bw.close();
        br.close();

    }

    /**
     * 노래방 랭킹 대시보드 구현체
     * LinkedHashMap 사용하여 insert 순서가 유지되도록 함
     */
    public static class Dashboard {
        // 점수 - 갯수 형태로 저장, 저장순서 = Rank
        private Map<Integer, Integer> rankList = new LinkedHashMap<>();
        //초기 생성 시 입력 최대갯수 제한 지정
        /**
         * @param score 점수를 입력받아 대시보드에 추가
         * @return 입력된 점수의 순위 (rank)를 반환,
         * 점수가 입력되지 못했을 경우 -1 반환
         */
        public void addScore(int score) {
            Integer count = rankList.get(score);
            if (count != null) rankList.put(score, count + 1);
            else rankList.put(score, 1);
        }

        /**
         * @param newScore
         * @return 새로운 점수의 대시보드 추가 시 랭킹
         */
        public int getNewScoreRank(int newScore) {
            int count = 1;
            for(int rankScore: rankList.keySet())
                if(rankScore > newScore)
                    count += rankList.get(rankScore);
                else break; 
            return count;
        }

        /** 
         * @param newScore
         * @return 새로운 점수의 대시보드 추가 시 순번
         */
        public int getNewScoreNo(int newScore) {
            int count = 1;
            for(int rankScore: rankList.keySet()) {
                if(rankScore > newScore)
                    count += rankList.get(rankScore);
                else if(rankScore == newScore) {
                    count += rankList.get(rankScore);
                    break;
                }
            }
            return count;
        }
    }
}
