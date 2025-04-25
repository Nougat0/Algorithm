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
        int[] coordinates = new int[n]; //좌표 배열
        Integer[] sortedDeDuped; //좌표 중복제거, 정렬한 배열
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        //좌표 배열과 index 배열 입력
        int coordinate;
        for(int i=0; i<n; i++) {
            coordinate = Integer.parseInt(st.nextToken());
            coordinates[i] = coordinate;
            set.add(coordinate);
        }
        sortedDeDuped = set.toArray(new Integer[0]);
        //index 배열만 정렬 (좌표 기준 오름차순)
        Arrays.sort(sortedDeDuped);

        int value, index;
        for(int i=0; i<n; i++) {//압축 좌표값 구하기
            value = coordinates[i];
            index = binarySearch(value, sortedDeDuped);
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
     * @param arr 정렬, 중복제거된 배열
     * @return
     */
    public static int binarySearch(int value, Integer[] arr) {
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
}