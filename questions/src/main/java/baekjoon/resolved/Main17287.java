package baekjoon.resolved;

import java.io.*;

public class Main17287 {
    /*
        https://www.acmicpc.net/problem/17287
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        int length = string.length();
        int score = 0;
        int maxScore = 0;
        for(int i=0; i<length; i++) {
            switch(string.charAt(i)) {
                case '(': score += 1; break;
                case '{': score += 2; break;
                case '[': score += 3; break;
                case ')': score -= 1; break;
                case '}': score -= 2; break;
                case ']': score -= 3; break;
                default: if(score > maxScore) maxScore = score;
            }
        }
        System.out.println(maxScore);
        br.close();
    }
}
