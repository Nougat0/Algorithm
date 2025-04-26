package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(arr, n);
        for(int i=0; i<n; i++) {
            sb.append(arr[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 배열 쪼개기
     * 왼쪽 + 오른쪽으로 계속 쪼갠다
     * @param arr
     * @param length
     */
    public static void mergeSort(int[] arr, int length) {
        if(length < 2) return; //길이가 1일 경우 실행중단
        //[1] 배열 변수 선언
        int mid = length / 2; //절반으로 자룰 한쪽 길이
        int[] left = new int[mid];
        int[] right = new int[length - mid];
        //[2] 쪼갠 배열 초기화
        for(int i=0; i<mid; i++)
            left[i] = arr[i];
        for(int i=mid; i<length; i++)
            right[i - mid] = arr[i];
        //[3] 쪼갠 배열에서 위 과정 반복
        mergeSort(left, mid);
        mergeSort(right, length - mid);

        //[4] 쪼갠 배열들 정렬하면서 병합
        merge(arr, left, right, mid, length - mid);

    }

    /**
     * 쪼갠 배열 정렬하면서 합치기
     * @param arr 원본 배열
     * @param left 왼쪽 배열
     * @param right 오른쪽 배열
     * @param leftLength 왼쪽 배열 길이
     * @param rightLength 오른쪽 배열 길이
     */
    public static void merge(int[] arr, int[] left, int[] right, int leftLength, int rightLength) {
        int leftIndex = 0, rightIndex = 0, mergedIndex = 0;
        while(leftIndex < leftLength && rightIndex < rightLength) {
            if(left[leftIndex] <= right[rightIndex])
                arr[mergedIndex++] = left[leftIndex++];
            else
                arr[mergedIndex++] = right[rightIndex++];
        }
        //남은 값 채워넣기
        while(leftIndex < leftLength)
            arr[mergedIndex++] = left[leftIndex++];
        while(rightIndex < rightLength)
            arr[mergedIndex++] = right[rightIndex++];
    }
}
