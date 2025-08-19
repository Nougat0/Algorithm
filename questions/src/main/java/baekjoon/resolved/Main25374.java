package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main25374 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/25374
    */
    public static void main(String[] args) throws IOException {
        /*
        점수 중복이 존재할 수 있으므로 단순 binarySearch 는 안됨 (점부별 개수(범위) 가늠이 안됨)
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] cutLines = new int[]{0, 4, 11, 23, 40, 60, 77, 89, 96, 100}; //1~9
        int[] cutLineCount = new int[10];

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] scoreCount = new int[n+1]; //0 ~ 100점까지 점수별 인원수 확인
        Set<Integer> scores = new HashSet<>();
        for(int i=1; i<=n; i++) {
            int score = Integer.parseInt(st.nextToken());
            scoreCount[score]++;
            scores.add(score);
        }
        List<Integer> scoreList = new ArrayList<>(scores);
        scoreList.sort(Comparator.reverseOrder());
        Iterator<Integer> it = scoreList.iterator(); //iterator 사용해서 100개 점수 1번만 순회
        int totalCount = 0;
        int lastCount = 0;
        for(int i=1; i<=9; i++) {
            while(it.hasNext()) {
                int score = it.next();
                if((totalCount += scoreCount[score]) >= cutLines[i]) {
                    cutLineCount[i] = totalCount - lastCount;
                    lastCount = totalCount;
                    //만약 이번 % 값보다 훨씬 커서 다음 등급을 넘어서면
                    //다음 넣어줄 등급을 조정해줘야 함
                    while(i < 9 && totalCount >= cutLines[i+1]) i++;
                    break;
                }
            }
        }
        for(int i=1; i<=9; i++) sb.append(cutLineCount[i]).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
