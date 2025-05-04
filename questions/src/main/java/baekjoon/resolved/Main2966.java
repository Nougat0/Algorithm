package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2966 {
    /*
        https://www.acmicpc.net/problem/2966
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int length = Integer.parseInt(br.readLine());
        char[] answerList = br.readLine().toCharArray();
        int scoreAdrian = 0, scoreBruno = 0, scoreGoran = 0;
        for(int i=0; i<length; i++) {
            char answer = answerList[i];
            scoreAdrian += matchAdrian(i, answer);
            scoreBruno += matchBruno(i, answer);
            scoreGoran += matchGoran(i, answer);
        }
        int maxScore = Math.max(Math.max(scoreAdrian, scoreBruno), scoreGoran);

        sb.append(maxScore).append("\n");
        if(scoreAdrian == maxScore) sb.append("Adrian\n");
        if(scoreBruno == maxScore) sb.append("Bruno\n");
        if(scoreGoran == maxScore) sb.append("Goran\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    //Adrian이 정답을 맞췄을 경우 1, 틀릴 경우 0
    public static int matchAdrian(int index, char answer) {
        return answer == ('A' + (index % 3)) ? 1 : 0;
    }

    //Bruno가 정답을 맞췄을 경우 1, 틀릴 경우 0
    public static int matchBruno(int index, char answer) {
        char guess;
        if(index % 2 == 0) guess = 'B';
        else {
            if((index / 2) % 2 == 0) guess = 'A';
            else guess = 'C';
        }
        return answer == guess ? 1 : 0;
    }

    //Goran이 정답을 맞췄을 경우 1, 틀릴 경우 0
    public static int matchGoran(int index, char answer) {
        char guess;
        switch(index % 6) {
            case 0: case 1: guess = 'C'; break;
            case 2: case 3: guess = 'A'; break;
            default: guess = 'B'; break;
        }
        return answer == guess ? 1 : 0;
    }
}
