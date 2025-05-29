package baekjoon.resolved;

import java.io.*;

public class Main6765 {
    /*
        https://www.acmicpc.net/problem/6765
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //분기처리보다는 청사진 만들어두는 게 깔끔..
        char[][] bluePrint = new char[][] {{'*', 'x', '*'}, {' ', 'x', 'x'}, {'*', ' ', '*'}};
        int k = Integer.parseInt(br.readLine());
        int length = 3*k;
        for(int row=0; row<length; row++) {
            for(int col=0; col<length; col++) {
                sb.append(bluePrint[row/k][col/k]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
