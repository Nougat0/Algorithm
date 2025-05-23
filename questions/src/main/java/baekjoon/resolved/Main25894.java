package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main25894 {
    /*
        https://www.acmicpc.net/problem/25894
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer soundAlike;
        String line;
        boolean isPalindrome;
        char[] pair; //a~z
        int testCase = Integer.parseInt(br.readLine());
        for(int t=1; t<=testCase; t++) {
            sb.append("Test case #").append(t).append(":\n");
            pair = new char[26];
            int soundAlikeCnt = Integer.parseInt(br.readLine());
            for(int i=0; i<soundAlikeCnt; i++) {
                soundAlike = new StringTokenizer(br.readLine());
                char first = soundAlike.nextToken().charAt(0);
                char second = soundAlike.nextToken().charAt(0);
                pair[first - 'a'] = second;
                pair[second - 'a'] = first;
            }
            int stringCnt = Integer.parseInt(br.readLine());
            for(int i=0; i<stringCnt; i++) {
                line = br.readLine();
                isPalindrome = true;
                int length = line.length();
                for(int j=0; j<length/2; j++){
                    char former = line.charAt(j);
                    char latter = line.charAt(length-1-j);
                    //pair 과 별개로 pair 있는지 여부를 기록하는 배열을 추가할까 하다가... 그게 그거 같아서 안함
                    if(!(former == latter || pair[former - 'a'] == latter)) {
                        isPalindrome = false;
                        break;
                    }
                }
                sb.append(line).append(' ').append(isPalindrome ? "YES" : "NO").append("\n");
            }
            if(t < testCase) sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
