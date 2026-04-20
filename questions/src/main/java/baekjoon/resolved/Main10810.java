package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main10810 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/10810
        https://www.acmicpc.net/source/77841698
        2024.05.04
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nm = br.readLine();
        int m = Integer.parseInt(nm.split(" ")[1]);
        int[] baskets = new int[Integer.parseInt(nm.split(" ")[0])]; //new로 선언 -> 각 요소의 최초 값 0
        for(int index=0; index<m; index++){
            String line = br.readLine();
            int i = Integer.parseInt(line.split(" ")[0]);
            int j = Integer.parseInt(line.split(" ")[1]);
            int k = Integer.parseInt(line.split(" ")[2]);
            for(int idx=i-1; idx<j; idx++){
                baskets[idx] = k;
            }
        }

        br.close();
        for(int i=0; i<baskets.length; i++){
            System.out.printf("%d ", baskets[i]);
        }
        System.out.println();
    }
}