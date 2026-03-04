package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main15151 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/15151
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); //소설 제작 기간 (초기값)
        int d = Integer.parseInt(st.nextToken()); //사망 일자 (작성 경과 일자)
        int daysPassed = 0;
        int novels = 0;
        /**
         * death(d+1)일째에 사망 예정 -> 그 당시 작성 완료 권수 확인
         * 1일 걸림 + 1일 후 사망(2일차) = 1권
         * 1일 걸림 + 2일 후 사망(3일차) = 1권
         * 1일 걸림 + 3일 후 사망(4일차) = 2권
         *  [1일 걸림 기준]
         *  1   2   3   4   5   6   7   8   (일)
         *  1   2   2   3   3   3   3   4   (작성중)
         *  0   1   1   2   2   2   2   3   (작성완)
         *
         *  2   4   8   16  (일)
         *  1   2   3   4   (작성완)
         *  k+1 k+2k+1  k+2k+4k+1   k+2k+4k+8k+1    (작성완 기준 일자 계산)
         *  0   0+1     0+1+2       0+1+2+3         (2^)
         *  지수의 합 공식: n^0 + n^1 + ... + n^l = n^(l+1) - 1
         *  
         *  결국 이 방식으로는 답을 못 찾음... ㅠ 너무 복잡하게 생각했나봄
         *  구현 방식으로 더하면서 진행
         */
        while(true) {
            daysPassed += k;
            if(daysPassed > d) break;
            k *= 2;
            novels++;
        }
        System.out.println(novels);
        br.close();
    }
}
