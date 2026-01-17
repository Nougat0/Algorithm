package baekjoon.resolved;

import java.io.*;

public class Main35097 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/35097
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            long sum = 0;
            //1*1 + 1*2 + 1*3 + ... 1*n;
            //1(1+2+3+...n);
            for(int i=1; i<=n; i++) {
                sum += i * n*(n+1)/2;
            }
            sb.append(sum).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
