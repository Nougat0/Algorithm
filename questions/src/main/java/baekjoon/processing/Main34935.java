package baekjoon.processing;

import java.io.*;
import java.util.*;
public class Main34935 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34935
    */
    public static void main(String[] args) throws IOException {
        /*
            오름차순: 숫자가 항상 다음숫자보다 작음
            비-내림차순: 숫자가 다음숫자보다 작거나 같다
            내림차순: 숫자가 항상 다음숫자보다 큼
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long current, former = 0;
        boolean ascending = true;
        for(int i=0; i<n; i++) {
            current = Long.parseLong(st.nextToken());
            if(current <= former) {
                ascending = false;
                break;
            } else {
                former = current;
            }
        }
        System.out.println(ascending ? 1 : 0);
        br.close();
    }
}
