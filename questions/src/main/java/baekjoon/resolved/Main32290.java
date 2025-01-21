package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main32290 {

    /*
    비트OR 연산하는 l, r 모두 1000 이하의 숫자
    1000은 이진법으로 1111101000 (10자리) 이며, 10자리 이진수의 최대값은 1023
    따라서 값 체크할 배열의 최대길이는 1024로 지정하면 된다 (0~1023)
     */
    public static final int MAXLENGTH = 1024;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //입력
        int l, r, x;
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        //수열 만들기
        int[] array = new int[r-l+1];
        for(int i=l; i<=r; i++) {
            array[i-l] = i|x;
        }
        //출력
        bw.write(mex(array) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 문제의 mex 함수 구현
     * @param array 오름차순으로 정렬된 수열
     * @return
     */
    public static int mex(int[] array) {
        int length = array.length;
        boolean[] unavailable = new boolean[MAXLENGTH];
        //등장한 숫자들 기록
        for(int i=0; i<length; i++) {
            unavailable[array[i]] = true;
        }
        //등장하지 않은 숫자 0부터 확인, 확인될 시 바로 반환
        for(int i=0; i<MAXLENGTH; i++) {
            if(!unavailable[i]) return i;
        }
        //전부 등장했으면 1024가 최소값
        return MAXLENGTH;
    }
}
