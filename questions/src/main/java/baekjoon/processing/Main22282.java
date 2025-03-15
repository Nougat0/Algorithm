package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main22282 {
    /*
    H값이 5라면,
    citation 5 이상인 paper가
    최소 5개 있어야 함

    H의 최대값은?

    * 큰 값은 모두 누적되어 카운트되어야 한다
    * 따라서 큰 citation부터 내려가면서 누적합으로 연산하기
    */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int MAX_CITATION = 1000_000_000;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int h_index = 0; //기본 h_index
        int maxIndex = 0; //주어진 citation 최대값 -> citations에서 사용할 거라 index
        int[] citations = new int[MAX_CITATION + 1]; //등장 빈도 세기
        //입력
        while(n-- > 0) {
            int c = Integer.parseInt(br.readLine());
            citations[c]++;
            maxIndex = Math.max(maxIndex, c);
        }
        //h_index 연산
        long sum = citations[maxIndex]; //누적합 첫 값으로 초기화
        int count; //citation 몇 개 있는지
        while(maxIndex-- > 0) {
            count = citations[maxIndex];
            if(count > 0 && (sum += count) / maxIndex >= 1) {
                h_index = maxIndex;
                break;
            }
        }
        bw.write(h_index + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
