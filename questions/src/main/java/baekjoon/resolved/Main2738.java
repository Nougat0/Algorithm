package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2738 {
    /*
        https://www.acmicpc.net/problem/2738
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/source/78516947
        2024.05.18
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] mergedMatrix = new int[n][m];

        //행렬 A,B 병합 matrix에 입력
        for(int i=0; i<n*2; i++){
            String[] line = br.readLine().split(" ");
            int row = i<n ? i : i-n;
            for(int j=0; j<m; j++){
                mergedMatrix[row][j] += Integer.parseInt(line[j]);
            }
        }
        br.close();

        //출력
        for(int[] row: mergedMatrix) {
            for(int num: row) {
                bw.write(num + " ");
            }
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}