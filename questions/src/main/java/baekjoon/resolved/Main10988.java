package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main10988 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/10988
        https://www.acmicpc.net/source/78307846
        2024.05.14
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int length = word.length();
        boolean isPalindrome = true;

        //대칭자리끼리 일치하는지 체크 (한가운데 1자는 체크 제외)
        for(int i=0; i<length/2; i++) {
            if(word.toCharArray()[i] != word.toCharArray()[length-1 -i]) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome ? 1 : 0); //true=1, false=0
        br.close();
    }
}
