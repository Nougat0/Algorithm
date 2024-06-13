package baekjoon.resolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toCharArray();
        //1=2, 2=3, 3=4... 0=11
        // A~Z = 65~90
        int[] alphabet = {
                3, 3, 3,
                4, 4, 4,
                5, 5, 5,
                6, 6, 6,
                7, 7, 7,
                8, 8, 8, 8,
                9, 9, 9,
                10, 10 ,10 ,10
        };
        int timeToDialect = 0;

        for(int i=0; i<word.length; i++) {
            timeToDialect += alphabet[word[i] - 65];
        }
        System.out.println(timeToDialect);
    }
}
