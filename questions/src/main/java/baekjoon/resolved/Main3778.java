package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main3778 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for(int i=1; i<=testCase; i++) { //테스트케이스별로 2개 line 읽기
            int countDistance = 0;
            char[] firstWord = br.readLine().toCharArray();
            char[] secondWord = br.readLine().toCharArray();
            int firstLength = firstWord.length;
            int secondLength = secondWord.length;
            if(firstLength == 0 || secondLength == 0) { //단어 길이 == 0
                countDistance = Math.max(firstLength, secondLength);
            } else { //단어 길이 > 0
                //알파벳별로 등장개수 확인 -> 둘이 같다면 0이 될 것, 같지 않다면 0이 아님
                int[] alphabetUsed = new int[26];
                for(int a=0; a<firstLength; a++) alphabetUsed[firstWord[a]-97]++;
                for(int a=0; a<secondLength; a++) alphabetUsed[secondWord[a]-97]--;
                int distance;
                for(int a=0; a<26; a++) { //알파벳별 차이 확인
                    distance = Math.abs(alphabetUsed[a]);
                    //차이나는 값은 모두 더하기
                    if(distance > 0) countDistance += distance;
                }
            }
            sb.append("Case #").append(i).append(": ").append(countDistance).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
