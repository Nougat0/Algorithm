package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main16390 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/16390
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        Dish dish = new Dish(m, n);
        for(int i=0; i<m; i++) {
            String line = br.readLine();
            for(int j=0; j<n; j++) {
                dish.setDish(i, j, line.charAt(j));
            }
        }
        int count = dish.countAmoebas();
        System.out.println(count);
        br.close();
    }

    public static class Dish {
        private int rows;
        private int cols;
        private boolean[][] dish;

        public Dish(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            this.dish = new boolean[rows][cols];
        }

        public void setDish(int row, int col, char c) {
            dish[row][col] = c == '#';
        }

        public int countAmoebas() {
            //모든 #은 온전한 형태의 아메바에 소속됨을 가정 (모두 loop에 소속됨)
            int count = 0;
            for(int i=0; i<rows; i++) {
                for(int j=0; j<cols; j++) {
                    if(dish[i][j]) {
                        check(i, j);
                        count++;
                    }
                }
            }
            return count;
        }

        //주변 8칸 탐색하여 다음 위치 확인
        private void check(int row, int col) {
            dish[row][col] = false;
            for(int i=row-1; i<=row+1; i++) {
                for(int j=col-1; j<=col+1; j++) {
                    if(i >= rows || i < 0 || j >= cols || j < 0 || i==row && j==col) continue;
                    if(dish[i][j]) check(i, j);
                }
            }
        }
    }
}
