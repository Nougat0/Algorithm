package baekjoon.resolved;

import java.io.*;

public class Main32371 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/32371
    */

    public static int minRow = 4;
    public static int minCol = 11;
    public static int maxRow = -1;
    public static int maxCol = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        char[][] keyboard = new char[4][10];
        //키보드 배열 확인
        for(int i=0; i<4; i++) {
            str = br.readLine();
            for(int j=0; j<10; j++) {
                keyboard[i][j] = str.charAt(j);
            }
        }
        //입력된 키 확인
        String input = br.readLine();
        for(int i=0; i<9; i++) {
            checkPosition(keyboard, input.charAt(i));
        }
        //중앙 확인
        int row = (minRow + maxRow) / 2;
        int col = (minCol + maxCol) / 2;
        System.out.println(keyboard[row][col]);
        br.close();
    }

    public static void checkPosition(char[][] keyboard, char c) {
        label:
        for(int i=0; i<4; i++) {
            for(int j=0; j<10; j++) {
                if(keyboard[i][j] == c) {
                    maxRow = Math.max(i, maxRow);
                    minRow = Math.min(i, minRow);
                    maxCol = Math.max(j, maxCol);
                    minCol = Math.min(j, minCol);
                    break label;
                }
            }
        }
    }
}
