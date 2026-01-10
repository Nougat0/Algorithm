package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1015 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/1015
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] result = new int[n];
        Integer[] index = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            index[i] = i;
        }
        /*
            P의 0번 숫자는 B의 index가 됨
            B의 index에 A의 0번이 들어감

            A의 0번을 B의 몇 번째로 넣고 싶은지 숫자 적기
            A의 작은 순서대로 0,1,2,3를 각 자리에 넣음

        */
        Arrays.sort(index, Comparator.comparingInt(i -> a[i]));
        for(int i=0; i<n; i++) {
            result[index[i]] = i;
        }
        for(int i=0; i<n; i++) {
            sb.append(result[i]).append(' ');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
