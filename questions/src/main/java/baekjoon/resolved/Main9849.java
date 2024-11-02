package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main9849 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] squareList = new int[n][4];
        int minX= 0, minY = 0;
        int maxX = Integer.MAX_VALUE, maxY = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++)
                squareList[i][j] = Integer.parseInt(st.nextToken());
            minX = Math.max(minX, squareList[i][0]);
            maxX = Math.min(maxX, squareList[i][1]);
            minY = Math.max(minY, squareList[i][2]);
            maxY = Math.min(maxY, squareList[i][3]);
        }
        if(minX >= maxX || minY >= maxY) bw.write(0 + "\n");
        else bw.write((maxX-minX)*(maxY-minY) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
