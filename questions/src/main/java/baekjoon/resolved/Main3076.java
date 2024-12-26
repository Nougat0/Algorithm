package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main3076 {
    public static final char BLACK = 'X';
    public static final char WHITE = '.';
    public static final String NEWLINE = "\n";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder chessBoard = new StringBuilder();
        StringTokenizer st;
        //입력
        st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int charInRow = Integer.parseInt(st.nextToken());
        int charInCol = Integer.parseInt(st.nextToken());
        //체스판 칸 출력
        for(int r=0; r<rows*charInRow; r++) {
            for(int c=0; c<cols*charInCol; c++) {
                chessBoard.append(c/charInCol%2 != 0 ^ r/charInRow%2 == 0 ? BLACK : WHITE);
            }
            chessBoard.append(NEWLINE);
        }
        bw.write(chessBoard.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
