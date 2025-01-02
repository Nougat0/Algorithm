package baekjoon.processing;

import java.io.*;

public class Main2754 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] word = br.readLine().toCharArray();
        char alphabet = word[0];
        double score = 0;
        if(alphabet != 'F') {
            score += (4-alphabet+65);
            char bonus = word[1];
            if(bonus == '+') score += 0.3;
            else if(bonus == '-') score -= 0.3;
        }
        bw.write(score + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
