package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main18870 {
    /*
        ttps://www.acmicpc.net/problem/18870
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] originCoords = new int[n]; //좌표 배열
        int[] sortedDeDupedCoords; //좌표 중복제거, 정렬한 배열
        Set<Integer> dedupedCoords = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        //좌표 배열과 index 배열 입력
        int coord;
        for(int i=0; i<n; i++) {
            coord = Integer.parseInt(st.nextToken());
            originCoords[i] = coord;
            dedupedCoords.add(coord);
        }
        sortedDeDupedCoords = dedupedCoords.stream().mapToInt(Integer::intValue).toArray();
        //index 배열만 정렬 (좌표 기준 오름차순)
        mergeSort(sortedDeDupedCoords, sortedDeDupedCoords.length);

        int value, compressedCoord;
        for(int i=0; i<n; i++) {//압축 좌표값 구하기
            value = originCoords[i];
            compressedCoord = binarySearch(value, sortedDeDupedCoords);
            sb.append(compressedCoord).append(' ');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * binarySearch (이진탐색)
     * 각 좌표별로 대략적인 indexes 에서의 위치 파악
     * (같은 숫자가 여러 개일 수 있으므로 러프한 위치를 파악함)
     * @param value index를 찾을 값
     * @param arr 정렬, 중복제거된 배열
     * @return
     */
    public static int binarySearch(int value, int[] arr) {
        int length = arr.length;
        int leftIndex = 0;
        int rightIndex = length - 1;
        int midIndex;
        int midValue;

        while(leftIndex < rightIndex) {
            midIndex = (leftIndex + rightIndex)/2;
            midValue = arr[midIndex];
            if(value == midValue) {
                return midIndex;
            } else if(value > midValue) {
                leftIndex = midIndex + 1;
            } else if(value < midValue) {
                rightIndex = midIndex - 1;
            }
        }
        return leftIndex;
    }

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