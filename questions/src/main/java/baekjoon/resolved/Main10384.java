package baekjoon.resolved;

import java.io.*;

public class Main10384 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/10384
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        final int N = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=N; testCase++) {
            int[] pangram = new int[26]; //매 testCase마다 0으로 초기화 필요
            String line = br.readLine();
            int length = line.length();
            for(int i=0; i<length; i++) {
                char c = line.charAt(i);
                //알파벳일 경우에만 count
                if(c >= 'A' && c <= 'Z') pangram[c - 'A']++;
                else if (c >= 'a' && c <= 'z') pangram[c - 'a']++;
            }
            //pangram 테스트
            int minLoop = 4;
            for(int i=0; i<26; i++) {
                minLoop = Math.min(pangram[i], minLoop);
            }
            //결과 출력
            sb.append("Case ").append(testCase).append(": ");
            if(minLoop == 0) sb.append("Not a pangram");
            else if(minLoop == 1) sb.append("Pangram!");
            else if(minLoop == 2) sb.append("Double pangram!!");
            else if(minLoop == 3) sb.append("Triple pangram!!!");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
