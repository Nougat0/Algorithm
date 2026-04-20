package baekjoon.resolved;

import java.util.*;
import java.io.*;

public class Main10814 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/10814
        https://www.acmicpc.net/source/62071509
        2023.06.14
    */
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i=0;i<n;i++) arr[i] = br.readLine();
        br.close();
        //병합정렬법 사용
        mergeSort(arr, n);

        for(String a: arr) System.out.println(a);
    }
    public static void mergeSort(String[] origin, int n) {
        if(n < 2) return;

        int mid = n/2;
        String[] one = new String[mid];
        String[] two = new String[n-mid];

        for(int i=0; i<mid; i++) {
            one[i] = origin[i];
        }
        for(int i=mid; i<n; i++) {
            two[i-mid] = origin[i];
        }
        mergeSort(one, mid);
        mergeSort(two, n-mid);
        merge(origin, one, two, mid, n-mid);
    }
    public static void merge(String[] origin, String[] one, String[] two, int left, int right) {
        int i=0, j=0, k=0;
        while(i<left && j<right) {
            if(getAge(one[i]) <= getAge(two[j])) origin[k++] = one[i++];
            else origin[k++] = two[j++];
        }
        while(i<left) origin[k++] = one[i++];
        while(j<right) origin[k++] = two[j++];
    }

    public static int getAge(String str) {
        return Integer.parseInt(str.split(" ")[0]);
    }
}