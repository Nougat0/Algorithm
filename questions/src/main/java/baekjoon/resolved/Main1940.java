package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1940 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/1940
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[10_000_001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[Integer.parseInt(st.nextToken())] = true;
        }
        int armor = 0;
        for(int i=1; i<m/2+1; i++) {
            //같은 재료 2번 사용 못함 예외처리 (m-i != i)
            if(m-i != i && arr[m - i] && arr[i]) armor++;
        }
        System.out.println(armor);
        br.close();
    }
}
