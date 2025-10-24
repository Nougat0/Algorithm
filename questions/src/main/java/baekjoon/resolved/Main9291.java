package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main9291 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/9291
    */
    public static final int ROW = 0;
    public static final int COL = 1;
    public static final int SQU = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] sudoku = new int[9][9];
        for(int testCase=1; testCase<=n; testCase++) {
            //입력
            for(int row=0; row<9; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col=0; col<9; col++) {
                    sudoku[row][col] = Integer.parseInt(st.nextToken());
                }
            }
            if(testCase < n) br.readLine(); //공백 한 줄 읽기
            //연산 + 출력
            sb.append("Case ").append(testCase).append(": ");
            checkValid:
            for(int i=0; i<9; i++) {
                boolean[][] check = new boolean[3][9];
                int startRow = i / 3 * 3;
                int startCol = i % 3 * 3;
                for(int j=0; j<9; j++) {
                    int rowNumber = sudoku[i][j] - 1;
                    int colNumber = sudoku[j][i] - 1;
                    int squareNumber = sudoku[startRow + j/3][startCol + j%3] - 1;
                    if(check[ROW][rowNumber] || check[COL][colNumber] || check[SQU][squareNumber]) {
                        sb.append("IN");
                        break checkValid;
                    } else {
                        check[ROW][rowNumber] = true;
                        check[COL][colNumber] = true;
                        check[SQU][squareNumber] = true;
                    }
                }
            }
            sb.append("CORRECT\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
