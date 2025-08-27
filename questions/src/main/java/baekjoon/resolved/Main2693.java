package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2693 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2693
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int[] numbers = new int[10];
        boolean[] arr = new boolean[1001];
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int index = 0;
            //숫자 10개 입력
            while(st.hasMoreTokens()) {
                int number = Integer.parseInt(st.nextToken());
                arr[number] = true;
                numbers[index++] = number;
            }
            //3번째 수 찾기
            int count = 0;
            for(int x=1000; x>0; x--) {
                if(arr[x]) count++;
                if(count == 3) {
                    sb.append(x).append("\n");
                    break;
                }
            }
            //배열 초기화
            for(int x=0; x<10; x++) {
                arr[numbers[x]] = false;
                numbers[x] = 0;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
