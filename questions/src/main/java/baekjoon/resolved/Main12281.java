package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main12281 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //선언
        StringTokenizer st;
        Integer[] alex, bob;
        boolean[] labels;
        int alexCnt, bobCnt, bookCnt;
        //테스트 케이스 loop
        int testCase = Integer.parseInt(br.readLine());
        for(int t=0; t<testCase; t++) {
            //초기화
            bookCnt = Integer.parseInt(br.readLine()); //책의 개수(전체)
            alexCnt = 0; bobCnt = 0; //각자 책의 개수
            labels = new boolean[bookCnt]; //Bob/Alex 자리 주인 기록용
            alex = new Integer[bookCnt]; //alex 책의 worth
            bob = new Integer[bookCnt]; //Bob 책의 worth
            //책 worth 입력
            st = new StringTokenizer(br.readLine());
            for(int b=0; b<bookCnt; b++) {
                int worth = Integer.parseInt(st.nextToken());
                labels[b] = worth % 2 == 0; //짝수(true) Bob -- 홀수(false) Alex
                if(labels[b]) {
                    bob[bobCnt++] = worth;
                } else {
                    alex[alexCnt++] = worth;
                }
            }
            //정렬 - 내장함수 mergeSort
            alex = Arrays.copyOf(alex, alexCnt);
            bob = Arrays.copyOf(bob, bobCnt);
            Arrays.sort(alex);
            Arrays.sort(bob, Comparator.reverseOrder());
            //출력
            sb.append("Case #").append(t+1).append(":");
            for(int i=0, a=0, b=0; i<bookCnt; i++) {
                sb.append(" ");
                if(labels[i]) {
                    sb.append(bob[b++]);
                } else {
                    sb.append(alex[a++]);
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
