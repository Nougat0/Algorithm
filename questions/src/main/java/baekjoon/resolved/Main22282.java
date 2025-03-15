package baekjoon.resolved;

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
    * (주의) 크기가 10억+1 인 배열 사용 시 메모리 초과가 뜬다... 유효한 citation 값만 사용하기
    * (주의) h_index 는 꼭 입력된 citation 중에서 나와야 하는 게 아니다...!
    * (주의) 그렇다고 등장한 citation 최대값부터 1까지 모든 후보값을 검사하면 시간 초과가 뜬다... 다른 해법 필요
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
        long sum = 0;
        for(int c : citations.keySet()) { //입력된 citation 값만 순회
            if((sum += citations.get(c)) >= c) {
                h_index = Math.max(h_index, c); //임시저장되던 h_index와 citation 값 중 큰 값을 채택
                break;
            } else {
                h_index = (int) sum; //sum을 임시 h_index 로 저장
            }
        }
        bw.write(h_index + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
