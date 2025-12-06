package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main32724 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/32724
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] xray = new boolean[n+1][m+1];
        boolean hasTumor = false;
        diagnosis:
        for(int r=1; r<=n; r++) {
            String row = br.readLine();
            for(int c=1; c<=m; c++) {
                boolean hasTissue = (row.charAt(c-1) - '0') == 1;
                if(hasTissue) {
                    // 2*2 공간 확인
                    if(checkTumor(xray, r, c)) {
                        hasTumor = true;
                        break diagnosis;
                    }
                    xray[r][c] = true;
                }
            }
        }
        System.out.println(hasTumor ? 1 : 0);
        br.close();
    }

    private static boolean checkTumor(boolean[][] xray, int row, int col) {
        //row,col 이 우측 하단 꼭지점으로 두고 2*2 공간 확인
        return xray[row-1][col-1] && xray[row-1][col] && xray[row][col-1];
    }
}
