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
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int h_index = 0; //기본 h_index
        Map<Integer, Integer> citations = new TreeMap<>(Collections.reverseOrder()); //key(=citation 값) 내림차순 자동정렬
        //입력
        while(n-- > 0) {
            int c = Integer.parseInt(br.readLine());
            citations.compute(c, (key, value) -> value == null ? 1 : (value+1));
        }
        //h_index 연산
        long sum = 0; //누적합 첫 값으로 초기화
        int count; //citation 몇 개 있는지
        for(Integer c : citations.keySet()) {
            count = citations.get(c);
            if((sum += count) / c >= 1) {
                h_index = c; //가능한 citation 값, 내림차순 탐색이므로 최대값임
                break;
            }
        }
        bw.write(h_index + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
