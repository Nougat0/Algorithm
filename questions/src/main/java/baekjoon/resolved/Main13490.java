package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main13490 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/13490
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int k, fishCount, rules, rule, index, fishScore, bestScore;
        int[] weight;
        List<Integer> bestFishes = new ArrayList<>();
        
        k = Integer.parseInt(br.readLine());
        for(int dataSet=1; dataSet<=k; dataSet++) {
            // 데이터셋 확인
            st = new StringTokenizer(br.readLine());
            fishCount = Integer.parseInt(st.nextToken());
            rules = Integer.parseInt(st.nextToken());
            // 각 조건의 가중치 입력
            weight = new int[rules];
            st = new StringTokenizer(br.readLine());
            for(rule=0; rule<rules; rule++) {
                weight[rule] = Integer.parseInt(st.nextToken());
            }

            bestFishes.clear();
            bestScore = -5_000;
            for(index=1; index<=fishCount; index++) {
                // 물고기 심사
                fishScore = 0;
                st = new StringTokenizer(br.readLine());
                for(rule=0; rule<rules; rule++) {
                    fishScore += weight[rule] * Integer.parseInt(st.nextToken());
                }
                // 최고값 갱신/유지 확인
                if(fishScore > bestScore) {
                    bestScore = fishScore;
                    bestFishes.clear();
                    bestFishes.add(index);
                } else if(fishScore == bestScore) {
                    bestFishes.add(index);
                }
            }
            //출력
            if(dataSet > 1) sb.append("\n");
            sb.append("Data Set ").append(dataSet).append(":\n");
            for(index=0; index<bestFishes.size(); index++) {
                sb.append(bestFishes.get(index)).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
