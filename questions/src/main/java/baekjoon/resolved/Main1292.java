package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int[] arr = new int[end+1]; arr[0] = 0;
        //계산
        int sum = 0, count = 0, number = 1;
        for(int i=1; i<=end; i++) {
            if(count == number) {
                number++;
                count = 0;
            }
            arr[i] = number;
            count++;
        }
        for(int i=start; i<=end; i++)
            sum += arr[i];
        //출력
        bw.write(sum +"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
