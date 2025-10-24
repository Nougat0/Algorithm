package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main9291 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/9291
    */
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
            for(int i=0; i<9; i++) {
                if(!checkCol(sudoku, i) || !checkRow(sudoku, i) || !checkSquare(sudoku, i)) {
                    sb.append("IN");
                    break;
                };
            }
            sb.append("CORRECT\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    // 가로줄 검사
    public static boolean checkRow(int[][] sudoku, int rowIndex) {
        boolean[] check = new boolean[9];
        for(int col=0; col<9; col++) {
            int number = sudoku[rowIndex][col] - 1;
            if(!check[number]) {
                check[number] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    // 세로줄 검사
    public static boolean checkCol(int[][] sudoku, int colIndex) {
        boolean[] check = new boolean[9];
        for(int row=0; row<9; row++) {
            int number = sudoku[row][colIndex] - 1;
            if(!check[number]) {
                check[number] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    // 3*3 으로 이뤄진 정사각형 내부 검사 (전체 9구간)
    public static boolean checkSquare(int[][] sudoku, int index) {
        boolean[] check = new boolean[9];
        int startRow = index / 3 * 3;
        int startCol = index % 3 * 3;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                int number = sudoku[startRow + i][startCol + j] - 1;
                if(!check[number]) {
                    check[number] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
