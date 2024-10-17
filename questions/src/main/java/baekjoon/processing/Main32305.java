package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main32305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalApples = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        int costOfDozen = Integer.parseInt(br.readLine());
        //연산 + 출력 (dozen 의 나머지가 있을 경우 dozen 으로 취급(올림))
        bw.write((totalApples/12 + (totalApples%12 == 0 ? 0 : 1)) * costOfDozen + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
