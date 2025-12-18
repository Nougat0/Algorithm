package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main10709 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/5544
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        int[][] sky = new int[rows][cols];
        for(int i=0; i<rows; i++) {
            String line = br.readLine();
            int cloudPos = -1;
            for(int j=0; j<cols; j++) {
                boolean cloudy = line.charAt(j) == 'c';
                if(cloudy) cloudPos = j;
                else if(cloudPos == -1) sky[i][j] = -1;
                else sky[i][j] = j - cloudPos;
                sb.append(sky[i][j]).append(' ');
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
