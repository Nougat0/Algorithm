package baekjoon.resolved;

import java.io.*;

public class Main21181 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/21181
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] pos = new int[n];
        for(int i=0; i<n; i++) {
            pos[i] = Integer.parseInt(br.readLine());
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                //i, j is host
                int sum = 0;
                for(int k=0; k<n; k++) {
                    if(k == i || k == j) continue;
                    int distance = Math.min(Math.abs(pos[k]-pos[i]), Math.abs(pos[k]-pos[j]));
                    sum += distance * distance;
                }
                if(min > sum) min = sum;
            }
        }
        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
