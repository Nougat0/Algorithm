package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main13987 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //입력
        int[][] dice = new int[2][6];
        for(int i=0; i<2; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<6; j++)
                dice[i][j] = Integer.parseInt(st.nextToken());
        }
        //연산
        int totalCase = 6*6;
        int winningCase = 0;
        for(int i=0; i<6; i++) {
            int eye = dice[0][i];
            for(int j=0; j<6; j++)
                //이기는 경우 산출
                if(eye > dice[1][j]) winningCase++;
                //비기는 경우는 제외하고 산출
                else if(eye == dice[1][j]) totalCase--;
        }
        //출력
        bw.write(String.format("%.5f%n",(double)winningCase/totalCase));
        bw.flush();
        bw.close();
        br.close();
    }
}
