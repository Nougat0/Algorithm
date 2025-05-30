package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main13274 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/13274

        참고한 글: https://ongveloper.tistory.com/374
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
        boolean sortNotNeeded;
        while(k-- > 0) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken()) - 1; //1~n 값 조정
            r = Integer.parseInt(st.nextToken()) - 1; //1~n 값 조정
            x = Integer.parseInt(st.nextToken());
            //재정렬 필요없는 경우 구하기
            sortNotNeeded = (x == 0) || (x > 0 && r == n-1) || (x < 0 && l == 0);

            //값 추가 - 양쪽 동시 진행하여 횟수/2
            int length = r-l+1;
            for(index=0; index<length/2; index++) {
                seq[l+index] += x;
                seq[r-index] += x;
            }
            if(length % 2 == 1) { //가운데 값 더하기
                seq[l+length/2] += x;
            }
            //재정렬할 필요없는 경우 continue (현재 위치 그대로)
            if(sortNotNeeded) continue;
            //정렬
            if(x > 0) merge(seq, l, r, n-1);
            else merge(seq, 0, l-1, r);
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
    public static void merge(long[] origin, int leftStart, int leftEnd, int rightEnd) {
        int leftIndex = leftStart, rightIndex = leftEnd + 1, mergedIndex = leftStart;
        //두 배열 중 짧은 쪽에 맞춰서 index 하나씩 비교, 정렬
        while(leftIndex <= leftEnd && rightIndex <= rightEnd)
            if(origin[leftIndex] <= origin[rightIndex]) sorted[mergedIndex++] = origin[leftIndex++];
            else sorted[mergedIndex++] = origin[rightIndex++];

        //남은 값 채워넣기 (왼쪽이든 오른쪽이든 한쪽만 남은 상태)
        while(leftIndex <= leftEnd) sorted[mergedIndex++] = origin[leftIndex++];
        while(rightIndex <= rightEnd) sorted[mergedIndex++] = origin[rightIndex++];

        //정렬결과를 기존 배열에 넣어줌
        for(int i=leftStart; i<=rightEnd; i++) origin[i] = sorted[i];
    }
}
