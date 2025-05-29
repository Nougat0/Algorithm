package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main10804 {
    /*
        https://www.acmicpc.net/problem/10804
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        //loop 사용 가능하나 가변 길이도 아니고 굳이 필요하지 않음
        int[] arr = new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int start, end, basket, halfLength;
        for(int t=0; t<10; t++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            halfLength = (end-start+1)/2;
            //역순 배치
            for(int i=0; i<halfLength; i++) {
                basket = arr[start + i];
                arr[start + i] = arr[end - i];
                arr[end - i] = basket;
            }
        }
        //출력
        for(int i=1; i<=20; i++) {
            sb.append(arr[i]).append(' ');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
