package baekjoon.resolved;

import java.io.*;

public class Main26516 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/26516
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringBuilder remains;
        while(true) {
            String n = br.readLine();
            if(n.charAt(0) == '0') break;
            int d = -1;
            int dIndex = -1;
            for(int i=0; i<n.length(); i++) {
                int digit = n.charAt(i) - '0';
                if(digit > d) {
                    d = digit;
                    dIndex = i;
                }
            }
            remains = new StringBuilder();
            if(d % 2 == 0) {
                int sum = d+4;
                if(sum > 9) sum %= 10;
                d = sum;
            } else {
                d = 0;
            }
            remains.append(n.substring(0, dIndex)).append(d).append(n.substring(dIndex+1, n.length()));
            sb.append(Integer.parseInt(remains.toString())).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
