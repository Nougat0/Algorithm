package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main2506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int questionCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int score = 1;
        int totalScore = 0;
        while(questionCnt-- > 0) {
            if(Integer.parseInt(st.nextToken()) == 1) {
                totalScore += score++;
            } else {
                score = 1;
            }
        }
        System.out.println(totalScore);
        br.close();
    }
}
