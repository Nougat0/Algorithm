package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main6080 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/6080
    */
    public static int[][] grass; //풀 높이
    public static boolean[][] checked; //확인한 곳
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        grass = new int[rows+2][cols+2]; //ArrayIndexOutOfBounds 대비용 크기
        checked = new boolean[rows+2][cols+2];

        //입력
        for(int i=1; i<=rows; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=cols; j++) {
                grass[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //분석
        int count = 0;
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=cols; j++) {
                //확인 시작 칸 (i, j)
                if(grass[i][j] > 0 && !checked[i][j]) {
                    check(i, j);
                    count++;
                }
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void check(int row, int col) {
        //주변 체크 -- 왼쪽→, 아래쪽↓, 대각선↘ ... 보다 더 다양하게 8방위로
        for(int i=-1; i<=1; i++) {
            for(int j=-1; j<=1; j++) {
                if(!checked[row+i][col+j] && grass[row+i][col+j] > 0) {
                    checked[row+i][col+j] = true;
                    check(row+i, col+j);
                }
            }
        }
    }
}
