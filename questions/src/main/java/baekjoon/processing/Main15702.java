package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main15702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int questionCnt = Integer.parseInt(st.nextToken());
        int studentCnt = Integer.parseInt(st.nextToken());
        int[] points = new int[questionCnt];
        //배점 기록
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<questionCnt; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }
        //점수 계산, 동시에 최고값 구하기
        int maxScore = 0;
        int maxScoreStudentNum = 0;
        for(int i=0; i<studentCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int studentNo = Integer.parseInt(st.nextToken());
            int score = 0;
            for(int j=0; j<questionCnt; j++)
                if(st.nextToken().equals("O"))
                    score += points[j];
            //최고값인지 체크, 학생번호 최소값 체크
            if(score > maxScore) {
                maxScore = score;
                maxScoreStudentNum = studentNo;
            } else if(score == maxScore) { //학생번호 제시 순서는 주어지지 않음
                maxScoreStudentNum = Math.min(maxScoreStudentNum, studentNo);
            }
        }
        //출력
        sb.append(maxScoreStudentNum).append(' ').append(maxScore);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
