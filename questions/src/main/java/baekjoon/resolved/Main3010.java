package baekjoon.resolved;

import java.io.*;

public class Main3010 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/3010
    */
    public static boolean[][] isBlank = new boolean[7][7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력
        for(int i=0; i<7; i++) {
            String line = br.readLine();
            for(int j=0; j<7; j++) {
                isBlank[i][j] = line.charAt(j) == '.';
            }
        }

        //판단
        int count = 0;
        for(int i=0; i<7; i++) {
            //usable 함수로 대체?
            int start = (i<2 || i>4) ? 2 : 0;
            int length = (i<2 || i>4) ? 3 : 7;
            for(int j=start; j<start+length; j++) {
                if(isBlank[i][j]) {
                    count += getValidMoves(i, j);
                }
            }
        }
        System.out.println(count);
        br.close();
    }

    //.oo 형태인지 상하좌우 확인
    public static int getValidMoves(int row, int col) {
        int count = 0;
        if(hasChip(row, col+1) && hasChip(row, col+2)) count++;
        if(hasChip(row, col-1) && hasChip(row, col-2)) count++;
        if(hasChip(row+1, col) && hasChip(row+2, col)) count++;
        if(hasChip(row-1, col) && hasChip(row-2, col)) count++;
        return count;
    }

    //유효한 칸인지, 칩이 있는지 확인
    public static boolean hasChip(int row, int col) {
        return usable(row, col) && !isBlank[row][col];
    }

    //ArrayIndexOutOfBounds 예외 처리, 빈공간 제외
    public static boolean usable(int row, int col) {
        if(row > 6 || col > 6 || row < 0 || col < 0) {
            return false;
        } else if(row<2 || row>4) {
            return col>=2 && col <=4;
        } else {
            return true;
        }
    }
}
