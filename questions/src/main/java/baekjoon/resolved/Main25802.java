package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main25802 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/25802
    */
    public static final int INIT_LENGTH = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int initialA = a, initialB = b; //초기값 저장
        int remainder; //시퀀스 새로운 값
        int seqLength = INIT_LENGTH; //시퀀스 길이
        while(!(seqLength > INIT_LENGTH && initialA == a && initialB == b)) {
            remainder = (a + b) % 10;
            a = b;
            b = remainder;
            seqLength++;
        }
        System.out.println(seqLength);
        br.close();
    }
}
