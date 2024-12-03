package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
        br.close();
        //병합정렬법 사용
        mergeSort(arr, n);
        //출력
        for(int i=0; i<n; i++) {
            sb.append(arr[i]);
            if(i<n-1) sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    public static void mergeSort(int[] origin, int n) {
        if(n < 2) return; //배열크기가 2보다 작을 시 실행중단

        int mid = n/2; //중앙값 index
        int[] one = new int[mid]; //좌측 배열
        int[] two = new int[n-mid]; //우측 배열

        for(int i=0; i<mid; i++) {//좌측 배열 복사
            one[i] = origin[i];
        }
        for(int i=mid; i<n; i++) {//우측 배열 복사
            two[i-mid] = origin[i];
        }
        mergeSort(one, mid); //재귀호출
        mergeSort(two, n-mid); //재귀호출
        merge(origin, one, two, mid, n-mid); //병합
    }
    public static void merge(int[] origin, int[] one, int[] two, int left, int right) {
        int i=0, j=0, k=0;
        while(i<left && j<right) {
            if(one[i] <= two[j]) origin[k++] = one[i++];
            else origin[k++] = two[j++];
        }
        while(i<left) origin[k++] = one[i++];
        while(j<right) origin[k++] = two[j++];
    }
}
