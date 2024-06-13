package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main14215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] side = new int[3];
        int max = -1, maxIndex = -1, sum = 0;

        /**
         * 3개 변 받기 + 최대값 찾기
         */
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++) {
            side[i] = Integer.parseInt(st.nextToken());
            sum += side[i];
            if(side[i] > max) {
                max = side[i];
                maxIndex = i;
            }
        }

        if(checkValid(side)) {
            bw.write(String.valueOf(sum));
        } else {
            //새로운 max 값 구하기
            int newMax = 0;
            //a+b+c = sum(기존둘레값)
            //a+b'+c = sum'(새로운둘레값)
            //a+c-1 = b'(새로운 max값의 최대값)
            //2a+2c-1 = sum'
            for(int i=0; i<3; i++) {
                if(i != maxIndex)
                    newMax += 2*side[i];
            }
            bw.write(String.valueOf(newMax - 1));
        };
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 유효한 삼각형인지 확인
     * @param sides
     * @return
     */
    public static boolean checkValid(int[] sides){
        int sum = 0, max = 0;
        for (int side : sides){
            sum += side;
            if (side > max) max = side;
        }
        //sum 값은 max 2배보다 커야 한다
        if(sum - 2*max > 0) return true;
        else return false;
    }
}