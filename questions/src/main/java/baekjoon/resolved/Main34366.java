package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main34366 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34366
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int months = Integer.parseInt(br.readLine());
        int highestScore = 14;
        int lowestScore = 1_001;
        int highestMonth = 14;
        int lowestMonth = 8_001;
        for(int m=0; m<months; m++) {
            st = new StringTokenizer(br.readLine());
            int scores = Integer.parseInt(st.nextToken());
            int thisMonthScore = 0;
            for(int s=0; s<scores; s++) {
                int score = Integer.parseInt(st.nextToken());
                thisMonthScore += score;
                if(score > highestScore) highestScore = score;
                if(score < lowestScore) lowestScore = score;
            }
            if(thisMonthScore > highestMonth) highestMonth = thisMonthScore;
            if(thisMonthScore < lowestMonth) lowestMonth = thisMonthScore;
        }
        sb.append(highestScore).append("\n")
            .append(lowestScore).append("\n")
            .append(highestMonth).append("\n")
            .append(lowestMonth).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
