package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2566 {
    /*
        https://www.acmicpc.net/problem/2566
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/source/78594272
        2024.05.20
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] arr = new int[9][9];

        //입력
        for (int i=0; i<9; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            for (int j=0; j<9; j++) {
                arr[i][j] = Integer.parseInt(line.nextToken());
            }
        }
        br.close();

        //최대값 찾기
        int max = -1, row = -1, col = -1;
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if(arr[i][j] > max) {
                    max = arr[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        //출력
        System.out.printf("%d%n%d %d%n", max, (row+1), (col+1));
        //bw.write(String.format("%d%n%d %d%n", max, (row+1), (col+1)));
        //bw.flush();
        //bw.close();
    }
}