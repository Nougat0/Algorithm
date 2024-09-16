package baekjoon.resolved;

import java.io.*;

public class Main23802 {
    public static final String at = "@";
    public static final String blank = " ";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cellSize = Integer.parseInt(br.readLine());
        int cellCount = 5; //셀의 개수
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<cellSize; i++) //셀 맨 윗줄
            sb.append(at.repeat(cellSize*cellCount) + "\n");
        for(int i=cellSize; i<cellSize*cellCount; i++) //셀 세로줄 
            sb.append(at.repeat(cellSize) + "\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
