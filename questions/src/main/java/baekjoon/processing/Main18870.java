package baekjoon.processing;

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
        int[] coordinates = new int[n]; //좌표 배열
        Integer[] indexes = new Integer[n]; //index 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        //좌표 배열과 index 배열 입력
        for(int i=0; i<n; i++) {
            coordinates[i] = Integer.parseInt(st.nextToken());
            indexes[i] = i;
        }
        //index 배열만 정렬 (좌표 기준 오름차순)
        Arrays.sort(indexes, Comparator.comparingInt(i -> coordinates[i]));

        for(int i=0; i<n; i++) {//압축 좌표값 구하기
            int value = coordinates[i];
            //[1] 대략적 위치 도출
            int index = binarySearch(value, coordinates, indexes);
            //[2] 정확한 위치 도출 (동일 값 맨 앞 index 찾기)
            while(index > 0 && coordinates[indexes[index - 1]] == value) {
                index--;
            }
            sb.append(index).append(' ');
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
     * @param arr 초기 배열
     * @param idx arr값 기준 정렬된 index 배열
     * @return
     */
    public static int binarySearch(int value, int[] arr, Integer[] idx) {
        int length = arr.length;
        int leftIndex = 0;
        int rightIndex = length - 1;
        int midIndex;
        int midValue;

        while(leftIndex < rightIndex) {
            midIndex = (leftIndex + rightIndex)/2;
            midValue = arr[idx[midIndex]];
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
}