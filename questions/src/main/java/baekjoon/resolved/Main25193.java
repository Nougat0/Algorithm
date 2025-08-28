package baekjoon.resolved;

import java.io.*;

public class Main25193 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/25193
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        int otherCount = 0;
        for(int i=0; i<n; i++) {
            if(line.charAt(i) != 'C') otherCount++;
        }
        int chickenCount = n - otherCount;
        System.out.printf("%.0f%n", Math.ceil((double) chickenCount/(otherCount + 1)));
        br.close();
    }
}
