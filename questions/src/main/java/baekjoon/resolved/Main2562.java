package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2562 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2562
        https://www.acmicpc.net/source/77645840
        2024.04.30
    */
    public static int count = 9;
    public static void main(String[] args) throws IOException {
        //입력 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[count];
        int max = 0;

        //자연수 9개 입력받아서 최대값인지 확인
        for(int i=0; i<count; i++){
            numbers[i] = Integer.parseInt(br.readLine());
            if(numbers[i] > max) max = numbers[i];
        }

        //출력
        System.out.println(max);
        System.out.println(getIndexFromArray(numbers, max) + 1);
    }

    /**
     * 요소가 배열의 몇 번째 index에 위치하는지 확인하고, 해당 index를 반환
     * @param array 배열
     * @param element 요소
     * @return 배열에 요소가 있을 경우 index, 없을 경우 -1
     */
    public static int getIndexFromArray(int[] array, int element) {
        for(int i=0; i<array.length; i++) {
            if(array[i] == element) return i;
        }
        //배열에 해당 요소가 없을 경우
        return -1;
    }
}