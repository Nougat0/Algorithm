package baekjoon.processing;

import java.io.*;
import java.util.StringTokenizer;

public class Main13274 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/13274
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        //입력
        int l, r, x;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] seq = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            seq[i] = Long.parseLong(st.nextToken());
        }
        //사전 정렬
        mergeSort(seq, n);
        //쿼리 실행
        while(k-- > 0) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken()) - 1; //1~n 값 조정
            r = Integer.parseInt(st.nextToken()) - 1; //1~n 값 조정
            x = Integer.parseInt(st.nextToken());
            //값 추가
            for(int i=l; i<=r; i++) {
                seq[i] += x;
            }
            //정렬
            mergeSort(seq, n);
        }
        //출력
        for(int i=0; i<n; i++) {
            sb.append(seq[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 병합정렬
     * @param arr
     * @return
     */
    public static void mergeSort(long[] arr, int length) {
        if(length < 2) return;
        //병합정렬 - 쪼개기
        int leftLength = length / 2;
        int rightLength = length - leftLength;

        long[] left = new long[leftLength];
        long[] right = new long[rightLength];

        for(int i=0; i<leftLength; i++) {
            left[i] = arr[i];
        }
        for(int i=leftLength; i<length; i++) {
            right[i - leftLength] = arr[i];
        }

        mergeSort(left, leftLength);
        mergeSort(right, rightLength);
        //병합정렬 - 합치기 + 정렬
        merge(arr, left, right, leftLength, rightLength);
    }

    /**
     * 병합 정렬 - 합치기 + 정렬
     */
    public static void merge(long[] arr, long[] left, long[] right, int leftLength, int rightLength) {
        int leftIndex = 0, rightIndex = 0, mergedIndex = 0;
        //두 배열 중 짧은 쪽에 맞춰서 index 하나씩 비교, 정렬
        while(leftIndex < leftLength && rightIndex < rightLength)
            if(left[leftIndex] <= right[rightIndex]) arr[mergedIndex++] = left[leftIndex++];
            else arr[mergedIndex++] = right[rightIndex++];

        //남은 값 채워넣기 (왼쪽 배열 먼저)
        while(leftIndex < leftLength) arr[mergedIndex++] = left[leftIndex++];
        while(rightIndex < rightLength) arr[mergedIndex++] = right[rightIndex++];
    }
}
