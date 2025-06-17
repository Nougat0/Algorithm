package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main14494 {
    /*
        https://www.acmicpc.net/problem/14494
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[][] paths = new long[n+1][m+1];
        final int mod = 1_000_000_007;
        //미리 채워넣기
        for(int i=1; i<=n; i++) paths[i][1] = 1;
        for(int i=1; i<=m; i++) paths[1][i] = 1;
        //DP 진행
        for(int row=2; row<=n; row++) {
            for(int col=2; col<=m; col++) {
                paths[row][col] = paths[row-1][col-1] % mod + paths[row-1][col] % mod + paths[row][col-1] % mod;
            }
        }
        //궁금한 점: (1,1) -> (1,1) 은 1인가? 0인가? => 1이라고 함
        //https://www.acmicpc.net/board/view/25518
        System.out.println(paths[n][m] % mod);
        br.close();
    }
}
