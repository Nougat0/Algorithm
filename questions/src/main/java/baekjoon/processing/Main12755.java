package baekjoon.processing;

import java.io.*;

public class Main12755 {
    /*
        https://www.acmicpc.net/problem/12755
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int length = 0;
        int number = 1;

        while(length < n) {
            length += (int) Math.log10(number) + 1;
            sb.append(number++);
        }
        bw.write(sb.toString().charAt(n-1));
        bw.flush();
        bw.close();
        br.close();
    }
}
