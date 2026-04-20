package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1316 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/1316
        https://www.acmicpc.net/source/78445704
        2024.05.17
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int groupCount = 0;
        for(int i=0; i<n; i++) {
            char[] word = br.readLine().toCharArray();
            boolean[] appearCheck = new boolean[26]; //97~122
            boolean isGroupCount = true;

            //단어 내부 체크
            for(int j=0; j<word.length; j++) {
                if(appearCheck[word[j]-97] == false) {
                    //이전에 등장한 적 없음
                    appearCheck[word[j]-97] = true;
                } else if(appearCheck[word[j]-97] && word[j-1] == word[j]) {
                    //이전 알파벳과 현재 알파벳이 일치하면 아무 동작 없음
                    //빠져도 되는 부분이지만 이해를 위해 남겨놓음
                } else if(appearCheck[word[j]-97] && word[j-1] != word[j]) {
                    //이전 알파벳과 일치하지 않을 경우 그룹 단어가 아님
                    isGroupCount = false;
                    break;
                }
            }
            //그룹 단어 여부 확인하여 count++
            if(isGroupCount) groupCount++;
        }

        System.out.println(groupCount);
        br.close();
    }
}
