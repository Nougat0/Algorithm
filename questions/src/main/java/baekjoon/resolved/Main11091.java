package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main11091 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int Code_A = 65; //알파벳 A 아스키 코드값
    static final int Code_a = 97; //알파벳 a 아스키 코드값
    static final int AlphabetCnt = 26; //알파벳 개수
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        final int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            boolean[] alphabet = new boolean[AlphabetCnt];
            String line = br.readLine();
            int length = line.length();
            //문장 내 알파벳 기록
            for(int c=0; c<length; c++) {
                int index = line.charAt(c);
                if(index >= Code_a && index <= Code_a + AlphabetCnt - 1) { //소문자
                    alphabet[index - Code_a] = true;
                } else if(index >= Code_A && index <= Code_A + AlphabetCnt - 1) { //대문자
                    alphabet[index - Code_A] = true;
                }
            }
            //누락 알파벳 확인
            boolean isPangram = true;
            StringBuilder missing = new StringBuilder();
            for(int a=0; a<AlphabetCnt; a++) {
                if(!alphabet[a]) {
                    missing.append((char) (a+Code_a)); //누락 문자 기록
                    isPangram = false;
                }
            }
            //출력문 작성
            if(isPangram) {
                sb.append("pangram");
            } else {
                sb.append("missing ").append(missing);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
