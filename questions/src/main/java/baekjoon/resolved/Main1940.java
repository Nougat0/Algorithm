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
        int max = 0, value;
        for(int i=0; i<n; i++) {
            value = Integer.parseInt(st.nextToken());
            if(max < value) max = value;
            arr[value] = true;
        }
        int armor = 0;
        if(max >= m / 2) { //m의 절반보다 최대값이 커야 loop 도는 의미 있음
            for(int i=1; i<m/2+1; i++) {
                //같은 재료 2번 사용 못함 예외처리 (m-i != i)
                if(m-i != i && arr[m - i] && arr[i]) armor++;
            }
        }
        System.out.println(armor);
        br.close();
    }
}
