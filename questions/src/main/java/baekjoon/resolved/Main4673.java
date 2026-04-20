package baekjoon.resolved;

import java.util.*;

public class Main4673 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/4673
        https://www.acmicpc.net/source/50696059
        2022.10.18
    */
    public static final int MAX_NUM = 10000;
    public static final int START_NUM = 1;

    static void selfNum2() {
        HashSet<Integer> set = new HashSet<>();
        int[]arr = new int[MAX_NUM];

        //d(n), n=i, 중복제거를 위해 HashSet에 담기
        for(int i=START_NUM; i<MAX_NUM;i++) {
            int sum=i;
            for(int k=0;k<i-1;k++) sum+=i%Math.pow(10,k+1)/Math.pow(10,k);
            set.add(sum);
        }
        //arr[j]에 값이 안 담기면 해당 인덱스는 <셀프넘버>
        for(Integer st:set)
            for(int j=START_NUM; j<MAX_NUM; j++)
                if(st==j) arr[j] = st;
        //셀프넘버를 인쇄
        System.out.println(1); // 첫 숫자 오류 하드코딩
        for(int j=3; j<MAX_NUM; j++)
            if(arr[j] == 0) System.out.println(j);
    }///selfNum2


    public static void main(String[] args) {
        selfNum2();
    }///main
}///class