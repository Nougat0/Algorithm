package baekjoon.resolved;

import java.io.*;

public class Main34553 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34553
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int length = line.length();
        //첫번째 값은 하드코딩으로 지정
        int score = 1;
        int sum = score;
        char letter = line.charAt(0);

        for(int i=1; i<length; i++) {
            char thisLetter = line.charAt(i);
            if(thisLetter > letter) score++;
            else score = 1;
            sum += score;
            letter = thisLetter;
        }
        System.out.println(sum);
        br.close();
    }
}
