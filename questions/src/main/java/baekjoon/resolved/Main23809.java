package baekjoon.resolved;

import java.io.*;

public class Main23809 {
    /*
        https://www.acmicpc.net/problem/23809
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        int length = 5*k;
        for(int row=0; row<length; row++) {
            for(int col=0; col<length; col++) {
                if(col/k == 1 && (row/k == 1 || row/k == 3)) sb.append(' '); //X모양에서 미리 제외
                else if(col/k == 0 || (row/k == 2 && col/k <= 2) || (col/k == row/k) || (col/k + row/k == 4)) sb.append('@');
                else if(col/k < row/k || col/k + row/k < 4) sb.append(' '); //안쪽 빈칸 찍기
                else break; //줄바꿈
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
