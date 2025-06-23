package baekjoon.resolved;

import java.io.*;

public class Main26529 {
    /*
        https://www.acmicpc.net/problem/26529
        https://www.acmicpc.net/user/bcdlife
    */
    public static long[] bunnies = new long[46];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        bunnies[0] = 1;
        bunnies[1] = 1;
        int month;
        while(n-- > 0) {
            month = Integer.parseInt(br.readLine());
            sb.append(getBunnies(month)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * DP 재귀방식
     * @param month
     * @return
     */
    public static long getBunnies(int month) {
        if(month < 2) {
            return bunnies[month];
        } else if(bunnies[month] == 0){
            bunnies[month] = getBunnies(month-1) + getBunnies(month-2);
            return bunnies[month];
        } else {
            return bunnies[month];
        }
    }
}
