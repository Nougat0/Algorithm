package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main7584 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/7584
    */
    public static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        while((line = br.readLine()).charAt(0) != '#') {
            st = new StringTokenizer(line);
            boolean isNought = st.nextToken().charAt(0) == 'O';
            board = new int[3][3];
            int count = 0;
            boolean isWin = false;
            while (st.hasMoreTokens() && !isWin) {
                count++;
                int num = Integer.parseInt(st.nextToken());
                int row = (num - 1) / 3;
                int col = (num - 1) % 3;

                board[row][col] = isNought ? 1 : 2;
                if(count >= 3) {
                    isWin = checkWin(num, row, col);
                }
                isNought = !isNought;
            }
            isNought = !isNought; //맨 마지막 다시 뒤집기
            sb.append(isWin ? (isNought ? 'O' : 'X') : "Draw").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean checkWin(int num, int row, int col) {
        boolean checkLeftTopDiag = (num % 4 == 1) && (board[0][0] == board[1][1] && board[1][1] == board[2][2]);
        boolean checkRightTopDiag = (num == 3 || num == 5 || num == 7) && (board[0][2] == board[1][1] && board[1][1] == board[2][0]);
        boolean checkRow = board[row][0] == board[row][1] && board[row][1] == board[row][2];
        boolean checkCol = board[0][col] == board[1][col] && board[1][col] == board[2][col];
        return checkLeftTopDiag || checkRightTopDiag || checkRow || checkCol;
    }
}
