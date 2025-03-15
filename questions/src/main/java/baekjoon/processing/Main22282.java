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
    * (주의) h_index 는 꼭 입력된 citation 중에서 나와야 하는 게 아니다...!
    */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int h_index = 0; //기본 h_index
        int maxCitation = 0; //입력된 citation 최대값
        Map<Integer, Integer> citations = new TreeMap<>(Collections.reverseOrder()); //key(=citation 값) 내림차순 자동정렬
        //입력
        while(n-- > 0) {
            int c = Integer.parseInt(br.readLine());
            citations.compute(c, (key, value) -> value == null ? 1 : (value+1));
            maxCitation = Math.max(maxCitation, c);
        }
        //h_index 연산
        long sum = 0; //누적합 첫 값으로 초기화
        int count; //citation 몇 개 있는지
        while(maxCitation > 0) { //maxCitation 변수값을 그대로 citation key값으로 사용
            count = citations.getOrDefault(maxCitation, 0); //해당 citation 없을 시 0
            if((sum += count) / maxCitation >= 1) {
                h_index = maxCitation;
                break;
            }
            maxCitation--; //다음 확인할 citation값
        }
        bw.write(h_index + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
