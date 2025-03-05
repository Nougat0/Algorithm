package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main32154 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static byte[][] solved = new byte[][] { //이... 이게 맞나...
            {1,1,1,1,1,1,1,1,0,1,0,1,1},
            {1,0,1,0,1,1,1,1,1,0,0,1,1},
            {1,0,1,0,1,1,1,1,1,0,0,1,1},
            {1,1,1,0,1,1,1,1,0,0,0,1,1},
            {1,0,1,0,1,1,1,1,0,0,0,1,1},
            {1,0,1,0,1,1,1,1,0,0,0,1,1},
            {1,0,1,0,1,1,1,1,0,0,0,1,1},
            {1,0,1,0,1,1,1,1,0,0,0,1,1},
            {1,0,1,0,1,1,1,1,0,0,0,1,1},
            {1,1,1,0,0,1,1,1,0,0,0,1,1}
    };
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringBuilder solvedLine = new StringBuilder();
        int rank = Integer.parseInt(br.readLine()) - 1;
        int solvedCnt = 0;
        for(int i=0; i<13; i++) {
            if(solved[rank][i] == 1) {
                solvedLine.append((char) (i + 'A')).append(' ');
                solvedCnt++;
            }
        }
        sb.append(solvedCnt).append("\n");
        sb.append(solvedLine);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
