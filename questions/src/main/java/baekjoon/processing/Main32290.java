package baekjoon.processing;

import javax.swing.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main32290 {
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
        boolean[] unavailable = new boolean[1001];
        for(int i=0; i<length; i++) {
            unavailable[array[i]] = true;
        }
        for(int i=0; i<=1001; i++) {
            if(!unavailable[i]) return i;
        }
        return 1001;
    }
}
