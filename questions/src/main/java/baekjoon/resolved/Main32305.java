package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main32305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalApples = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        int costOfDozen = Integer.parseInt(br.readLine());
        //연산 + 출력 (dozen 의 나머지가 있을 경우 dozen 으로 취급(올림))
        System.out.println((totalApples + 11)/12 * costOfDozen);
        br.close();
    }
}
