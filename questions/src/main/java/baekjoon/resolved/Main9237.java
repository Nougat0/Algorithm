package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main9237 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/9237
    */
    public static int[] sortingArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] growingDays = new int[n];
        sortingArr = new int[n]; //정렬용 임시배열 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            growingDays[i] = Integer.parseInt(st.nextToken());
        }
        //오름차순 정렬 후 뒤에서부터 보기
        mergeSort(growingDays, 0, n-1);
        int maxTime = 0;
        for(int i=1; i<=n; i++) {
            if(growingDays[n-i] + i > maxTime) maxTime = growingDays[n-i] + i;
        }
        System.out.println(maxTime + 1);
        br.close();
    }

    /**
     * 병합정렬 + index 활용(신규 배열 선언/new X)
     * @param arr
     * @return
     */
    public static void mergeSort(int[] arr, int leftIndex, int rightIndex) {
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
    public static void merge(int[] origin, int leftStart, int leftEnd, int rightEnd) {
        int leftIndex = leftStart, rightIndex = leftEnd + 1, mergedIndex = leftStart;
        //두 배열 중 짧은 쪽에 맞춰서 index 하나씩 비교, 정렬
        while(leftIndex <= leftEnd && rightIndex <= rightEnd)
            if(origin[leftIndex] <= origin[rightIndex]) sortingArr[mergedIndex++] = origin[leftIndex++];
            else sortingArr[mergedIndex++] = origin[rightIndex++];

        //남은 값 채워넣기 (왼쪽이든 오른쪽이든 한쪽만 남은 상태)
        while(leftIndex <= leftEnd) sortingArr[mergedIndex++] = origin[leftIndex++];
        while(rightIndex <= rightEnd) sortingArr[mergedIndex++] = origin[rightIndex++];

        //정렬결과를 기존 배열에 넣어줌
        for(int i=leftStart; i<=rightEnd; i++) origin[i] = sortingArr[i];
    }
}
