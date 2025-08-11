package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main30980 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/30980
    */
    public static final String DOT = ".";
    public static final String STAR = "*";
    public static final String SLASH = "/";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String line, question;
        for(int i=0; i<3*n; i++) {
            line = br.readLine();
            if(i%3 == 1) {
                st = new StringTokenizer(line, ".", false);
                StringBuilder over = new StringBuilder();
                StringBuilder questions = new StringBuilder();
                StringBuilder under = new StringBuilder();
                for(int q=0; q<m; q++) {
                    question = st.nextToken();
                    int length = question.length();
                    if(checkQuestion(question, length)) {
                        over.append(DOT).append(STAR.repeat(length)).append(DOT.repeat(7 - length));
                        questions.append(STAR).append(question).append(STAR).append(DOT.repeat(6 - length));
                        under.append(DOT).append(STAR.repeat(length)).append(DOT.repeat(7 - length));
                    } else {
                        over.append(DOT.repeat(3)).append(SLASH).append(DOT.repeat(4));
                        questions.append(DOT).append(question.replace("+", SLASH)).append(DOT.repeat(7 - length));
                        under.append(DOT).append(SLASH).append(DOT.repeat(6));
                    }
                }
                sb.append(over).append("\n").append(questions).append("\n").append(under).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean checkQuestion(String question, int length) {
        int a = Character.getNumericValue(question.charAt(0));
        int b = Character.getNumericValue(question.charAt(2));
        int c1 = Character.getNumericValue(question.charAt(4));
        int c = length == 6 ? c1*10 + Character.getNumericValue(question.charAt(5)) : c1;

        return a + b == c;
    }
}
