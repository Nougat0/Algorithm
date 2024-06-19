package baekjoon.resolved;

import java.io.*;
import java.util.*;
public class Main2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = 0;

        //입력
        int[] arr = new int[5];
        for(int i=0; i<5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        //정렬
        for(int i=0; i<4; i++) {
            for(int j=i+1; j<5; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        //출력
        bw.write(String.format("%d%n%d%n", sum/5, arr[2]));
        bw.flush();
        bw.close();
        br.close();
    }
}
