package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main13274 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/13274
    */

    public static long[] sorted; //정렬 결과 저장용 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        //입력
        int l, r, x;
        st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] seq = new long[n];
        st = new StringTokenizer(br.readLine());
        int index = 0;
        while(index < n) {
            seq[index++] = Long.parseLong(st.nextToken());
        }
        //사전 정렬
        sorted = new long[n];
        mergeSort(seq, 0, n-1);
        //쿼리 실행
        while(k-- > 0) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken()) - 1; //1~n 값 조정
            r = Integer.parseInt(st.nextToken()) - 1; //1~n 값 조정
            x = Integer.parseInt(st.nextToken());
            //더한 후 값의 더하기 전 index 확인
            int start = binarySearch(seq, seq[l]+x);
            int end = binarySearch(seq, seq[r]+x);
            int min = Math.min(start, l);
            int max = Math.max(end, r);
            //값 추가 - 양쪽 동시 진행하여 횟수/2
            int length = r-l+1;
            for(index=0; index<length/2; index++) {
                seq[l+index] += x;
                seq[r-index] += x;
            }
            if(length % 2 == 1) { //가운데 값 더하기
                seq[l+length/2] += x;
            }
            //정렬
            mergeSort(seq, min, max);
        }
        //출력
        for(index=0; index<n; index++) {
            sb.append(seq[index]).append(' ');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 병합정렬 + 이진탐색
     * @param arr
     * @return
     */
    public static void mergeSort(long[] arr, int leftIndex, int rightIndex) {
        if(leftIndex >= rightIndex) return;
        //병합정렬 - 쪼개기 (쪼갠 결과를 index로 전달하여 관리)
        int midIndex = (leftIndex + rightIndex) / 2;
        mergeSort(arr, leftIndex, midIndex);
        mergeSort(arr, midIndex + 1, rightIndex);
        //병합정렬 - 쪼개진 배열 부분별로 정렬
        merge(arr, leftIndex, midIndex, rightIndex);
    }

    /**
     * 병합 정렬 - 쪼개진 배열 부분별로 정렬
     */
    public static void merge(long[] origin, int start, int mid, int end) {
        int leftIndex = start, rightIndex = mid + 1, mergedIndex = start;
        //두 배열 중 짧은 쪽에 맞춰서 index 하나씩 비교, 정렬
        while(leftIndex <= mid && rightIndex <= end)
            if(origin[leftIndex] <= origin[rightIndex]) sorted[mergedIndex++] = origin[leftIndex++];
            else sorted[mergedIndex++] = origin[rightIndex++];

        //남은 값 채워넣기 (왼쪽 배열 먼저)
        while(leftIndex <= mid) sorted[mergedIndex++] = origin[leftIndex++];
        while(rightIndex <= end) sorted[mergedIndex++] = origin[rightIndex++];

        //정렬결과를 기존 배열에 넣어줌
        for(int i=start; i<=end; i++) origin[i] = sorted[i];
    }


    /**
     * 전달된 값이 배열의 어느 범위에 있는지 확인
     * @param arr
     * @param value
     * @return
     */
    public static int binarySearch(long[] arr, long value) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int midIndex;
        long midValue;

        while(leftIndex <= rightIndex) {
            midIndex = (leftIndex + rightIndex)/2;
            midValue = arr[midIndex];
            if(midValue == value) return midIndex;
            else if(arr[rightIndex] < value) return rightIndex;
            else if(arr[leftIndex] > value) return leftIndex;
            else if(midValue > value) rightIndex = midIndex;
            else if(midValue < value) leftIndex = midIndex;
        }
        return leftIndex;
    }
}
