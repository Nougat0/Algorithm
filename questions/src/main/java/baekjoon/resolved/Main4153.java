package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main4153 {
    public static final String right = "right";
    public static final String wrong = "wrong";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true) {
            //입력 + 최대값 구하기
            List<Integer> triangle = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int max = 0; //세 변 중 최대값
            for(int i=0; i<3; i++) {
                triangle.add(i, Integer.parseInt(st.nextToken()));
                if(triangle.get(i) > max) max = triangle.get(i);
            }
            if(max == 0) break;
            //연산 + 출력
            bw.write(checkRight(triangle, max));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 직각삼각형인지 확인하는 메소드
     * @param triangle 세 변을 담은 List
     * @param max 세 변 중 최대값
     * @return 직각삼각형일 경우 right, 아닐 경우 false
     */
    public static String checkRight(List<Integer> triangle, int max) {
        triangle.remove(Integer.valueOf(max));
        if(Math.pow(triangle.get(0),2) + Math.pow(triangle.get(1),2) == Math.pow(max, 2))
            return right;
        else return wrong;
    }
}
