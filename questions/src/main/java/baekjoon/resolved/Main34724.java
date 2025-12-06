package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main34724 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34724
        주석 문제번호 잘못 기입했었음...
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] xray = new int[n+2][m+2];
        boolean hasTumor = false;
        diagnosis:
        for(int r=1; r<=n; r++) {
            String row = br.readLine();
            for(int c=1; c<=m; c++) {
                boolean hasTissue = (row.charAt(c-1) - '0') == 1;
                if(hasTissue) {
                    // 2*2 공간 확인
                    if(xray[r][c] >= 3) {
                        hasTumor = true;
                        break diagnosis;
                    }
                    xray[r][c+1]++;
                    xray[r+1][c]++;
                    xray[r+1][c+1]++;
                }
            }
        }
        System.out.println(hasTumor ? 1 : 0);
        br.close();
    }
}
