package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main10813 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/10813
        https://www.acmicpc.net/source/77857656
        2024.05.04
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nm = br.readLine();
        int m = Integer.parseInt(nm.split(" ")[1]);
        int[] baskets = new int[Integer.parseInt(nm.split(" ")[0])];
        //바구니 값 채우기 (1~N)
        for(int index=0; index<baskets.length; index++){
            baskets[index] = index + 1;
        }
        //M번 바구니 값 바꾸기
        for(int index=0; index<m; index++){
            String line = br.readLine();
            int i = Integer.parseInt(line.split(" ")[0]);
            int j = Integer.parseInt(line.split(" ")[1]);
            //값 바꾸는 로직
            int temp = baskets[i-1];
            baskets[i-1] = baskets[j-1];
            baskets[j-1] = temp;
        }
        //출력
        for(int i=0; i<baskets.length; i++){
            System.out.printf("%d ", baskets[i]);
        }
        System.out.println();
    }
}