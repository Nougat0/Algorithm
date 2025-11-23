package baekjoon.resolved;

import java.io.*;

public class Main34455 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34455
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int d = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        for(int i=0; i<e; i++) {
            char calc = br.readLine().charAt(0);
            int num = Integer.parseInt(br.readLine());
            if(calc == '+') {
                d += num;
            } else {
                d -= num;
            }
        }
        bw.write(d + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
