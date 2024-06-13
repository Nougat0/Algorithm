package baekjoon.resolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] arr = s.toCharArray();
        //알파벳 소문자 97~122
        for(int i=0; i<26; i++) {
            System.out.printf("%d ", findIndex(arr, (char) (i+97)));
        }
        System.out.println();
    }
    //element의 배열 index 값 찾는 메소드 생성하여 사용
    public static int findIndex(char[] arr, char element) {
        int length = arr.length;
        for(int i=0; i<length; i++) {
            if(arr[i] == element) return i;
        }
        return -1; //없을 경우 -1 반환
    }
}
