package baekjoon.resolved;

import java.io.*;

public class Main2721 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2721
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int w = w(n);
            sb.append(w).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    public static int t(int n) {
        return n*(n+1)/2;
    }

    public static int w(int n) {
        int sum = 0;
        for(int k=1; k<=n; k++) {
            sum += k * t(k+1);
        }
        return sum;
    }
}
