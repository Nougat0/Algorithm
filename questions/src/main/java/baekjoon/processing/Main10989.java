package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] inputArr = new int[n];
        int[] outputArr = new int[n];
        int[] countingSort = new int[10001];
        for(int i=0; i<n; i++) {
            inputArr[i] = Integer.parseInt(br.readLine());
            countingSort[inputArr[i]]++;
        }
        br.close();
        //CountingSort 방식 사용
        for(int i=1; i<=10000; i++) {
            countingSort[i] = countingSort[i-1] + countingSort[i];
        }
        for(int i=n-1; i>=0; i--) {
            int outputIndex = countingSort[inputArr[i]]-1; //이번 인덱스
            outputArr[outputIndex] = inputArr[i]; //출력배열 특정위치(인덱스)에 값 넣기
            countingSort[inputArr[i]]--; //같은 수의 다음인덱스 업데이트
        }
        
        //출력
        for(int i=0; i<n; i++) {
            sb.append(outputArr[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
