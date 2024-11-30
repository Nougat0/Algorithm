package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main6876 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
        StringBuilder finalSb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for(int t=0; t<testCase; t++) {
            sb = new StringBuilder();
            char[] numbers= br.readLine().toCharArray();
            for(char n: numbers) {
                if(Character.isDigit(n)) {
                    sb.append(n);
                } else if(Character.isAlphabetic(n)){
                    int upper = Character.toUpperCase(n);
                    //65~90 -> 0~25
                    sb.append(getNumber(upper-65));
                }
                //하이픈 붙이기
                if(sb.length() == 3 || sb.length() == 7) sb.append("-");
            }
            sb.setLength(12); //초과되는 길이는 자르기
            finalSb.append(sb).append("\n");
        }
        bw.write(finalSb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 다이얼에 적힌 알파벳 => 숫자 대응
     * @param alphaNumber
     * @return
     */
    static final int getNumber(int alphaNumber) {
        switch(alphaNumber) {
            case 0: case 1: case 2:
                return 2;
            case 3: case 4: case 5:
                return 3;
            case 6: case 7: case 8:
                return 4;
            case 9: case 10: case 11:
                return 5;
            case 12: case 13: case 14:
                return 6;
            case 15: case 16: case 17: case 18:
                return 7;
            case 19: case 20: case 21:
                return 8;
            default:
                return 9;
        }
    }
}
