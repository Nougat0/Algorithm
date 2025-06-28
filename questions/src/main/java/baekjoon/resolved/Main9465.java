package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main9465 {
    /*
        https://www.acmicpc.net/problem/9465
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer upperRow;
        StringTokenizer lowerRow;
        int testCases = Integer.parseInt(br.readLine());
        int n; //행의 개수
        int upper, lower; //각 행의 입력값 저장 변수
        int upperTemp, lowerTemp, noneTemp; //연산결과 저장 임시변수
        int upperMax, lowerMax, noneMax; //최대값 저장 변수
        //각 행별로 선택지는 3가지 존재한다 -> 위, 아래, X(none)
        while(testCases-- > 0) {
            n = Integer.parseInt(br.readLine());
            upperRow = new StringTokenizer(br.readLine());
            lowerRow = new StringTokenizer(br.readLine());
            //1행은 입력값이 곧 max값
            upperMax = Integer.parseInt(upperRow.nextToken());
            lowerMax = Integer.parseInt(lowerRow.nextToken());
            noneMax = 0;
            for(int i=2; i<=n; i++) {
                upper = Integer.parseInt(upperRow.nextToken());
                lower = Integer.parseInt(lowerRow.nextToken());
                //이번 행의 선택지 경우별 max값 구하기
                upperTemp = Math.max(lowerMax, noneMax) + upper;
                lowerTemp = Math.max(upperMax, noneMax) + lower;
                noneTemp = Math.max(upperMax, lowerMax); //+ 0
                //옮겨담기
                upperMax = upperTemp;
                lowerMax = lowerTemp;
                noneMax = noneTemp;
            }
            sb.append(Math.max(Math.max(upperMax, lowerMax), noneMax)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
