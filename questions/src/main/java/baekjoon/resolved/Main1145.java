package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1145 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] number = new int[5];
        for(int i=0; i<5; i++) number[i] = Integer.parseInt(st.nextToken());
        
        bw.write(getLeastCommonMultiple(number) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * @param number 자연수 배열
     * @return int 주어진 배열의 '적어도 대부분의 배수'
     */
    private static int getLeastCommonMultiple(int[] number) {
        Arrays.sort(number); //크기순으로 정렬
        int leastCommonMultiple = Integer.MAX_VALUE; //최소공배수를 int 최대값으로 설정
        int commonMultiple;
        //모든 3개 숫자 조합 체크
        for(int i=0; i<3; i++)
            for(int j=i+1; j<4; j++)
                for(int k=j+1; k<5; k++) {
                    commonMultiple = getCommonMultiple(number[i], number[j], number[k]);
                    if(leastCommonMultiple > commonMultiple) leastCommonMultiple = commonMultiple;
                }
        return leastCommonMultiple;
    }

    /**
     * @param i < @param j < @param k
     * @return int 3개 자연수의 최소공배수
     */
    public static int getCommonMultiple(int i, int j, int k) {
        int multiply = 2;
        while(true) {
            if(i*multiply % j == 0 && i*multiply % k == 0)
                return i*multiply;
            multiply++;
        }
    }
}
