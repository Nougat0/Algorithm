package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main24418 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/24418
    */
    public static int recursionCount = 0;
    public static int dpCount = 0;
    public static int[][] m;
    public static int[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        //입력
        int n = Integer.parseInt(br.readLine());
        m = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //실행
        recursion(n);
        dp(n);

        //출력
        sb.append(recursionCount).append(' ').append(dpCount);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 의사 코드 직접 실행
    public static long recursion(int n) {
        return recursionRec(n, n);
    }

    public static long recursionRec(int i, int j) {
        if(i==0 || j==0) {
            recursionCount++;
            return 0;
        } else {
            return m[i][j] + Math.max(recursionRec(i-1, j), recursionRec(i, j-1));
        }
    }

    public static void dp(int n) {
        d = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                d[i][j] = m[i][j] + Math.max(d[i-1][j], d[i][j-1]);
                dpCount++;
            }
        }
    }
}
