package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main31796 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/31796
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int MAX_LENGTH = 1_000_000 + 1; //10^3 ~ 10^6
        int n = Integer.parseInt(br.readLine());
        int[] books = new int[MAX_LENGTH];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = MAX_LENGTH;
        int max = 0;
        int value;
        for(int i=0; i<n; i++) {
            value = Integer.parseInt(st.nextToken());
            books[value]++;
            if(min > value) min = value;
            if(max < value) max = value;
        }

        /**
         * 동작 정리:
         * 1) 최소값 정해지면 최소값*2 가 다음 페이지의 예상 최소값이 됨
         * 2) 예상 최소값부터 책이 있는지 가격++ 하면서 확인
         * 3) 책이 발견되면 이번 페이지에 들어갈 가격의 최소값이 정해짐, 다시 1)부터 반복
         * *) 첫 번째 책은 미리 지정 가능
         */
        int price = min * 2; //다음 페이지 최소값
        int pages = 1;
        while(price <= max) {
            value = books[price];
            if(value == 0) price++;
            else { //페이지 생성
                price = price*2; //다음 페이지의 예상 최소값 지정
                pages++;
            }
        }
        System.out.println(pages);
        br.close();
    }
}
