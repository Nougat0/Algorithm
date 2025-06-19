package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main24392 {
    /*
        https://www.acmicpc.net/problem/24392
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MOD = 1_000_000_007;
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        int[] count = new int[cols+2]; //맨 앞, 맨 뒤 공간 남겨둠
        int[] newRow = new int[cols+2]; //맨 앞, 맨 뒤 공간 남겨둠
        //첫 줄 초기화
        st = new StringTokenizer(br.readLine());
        for(int col=1; col<=cols; col++) count[col] = Integer.parseInt(st.nextToken());

        //둘째 줄부터는 이전 경우의 수 덧셈
        boolean usable;
        for(int row=1; row<rows; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=1; col<=cols; col++) {
                 usable= st.nextToken().charAt(0) == '1';
                 if(usable) {
                     newRow[col] = count[col-1] % MOD  + count[col] % MOD + count[col+1] % MOD;
                 } else {
                     newRow[col] = 0;
                 }
            }
            //연산된 값 넣어주기
            for(int col=1; col<=cols; col++) count[col] = newRow[col];
        }
        int cases = 0; //최종 건널 수 있는 경우의 수
        for(int col=1; col<=cols; col++) cases = (cases + count[col]) % MOD;
        System.out.println(cases);
        br.close();
    }
}
