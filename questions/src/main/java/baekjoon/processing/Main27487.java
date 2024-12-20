package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main27487 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer seq;
        int testCase = Integer.parseInt(br.readLine());
        /**
         * 2와 1의 수열의 양측 곱이 일치하려면 양측 등장하는 2의 개수가 동일해야 함
         * 1) 동일하지 못할 경우 -1 출력
         * 2) 동일할 경우 좌측 마지막 2의 인덱스 출력 (인덱스 최소값)
         * 3) 2가 등장하지 않을 경우 전체 수열의 가운데 인덱스 출력
         */
        for(int t=0; t<testCase; t++) {
            int length = Integer.parseInt(br.readLine());
            seq = new StringTokenizer(br.readLine());
            //2의 개수 세기
            List<Integer> twoList = new ArrayList<>();
            int twoListSize = 0;
            for(int i=0; i<length; i++)
                if(Integer.parseInt(seq.nextToken()) == 2) {
                    twoList.add(i); //2가 있는 인덱스 추가하기
                    twoListSize++;
                }
            //출력
            if(twoListSize == 0) { //2가 등장하지 않음
                sb.append(length/2 - 1);
            } else if(twoListSize%2 == 0) { //2의 개수가 짝수
                sb.append(twoList.get(twoListSize/2 - 1) + 1);
            } else { //2의 개수가 홀수
                sb.append(-1);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
