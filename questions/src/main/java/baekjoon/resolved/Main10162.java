package baekjoon.resolved;

import java.io.*;

public class Main10162 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/10162
    */
    private static final int A = 300;
    private static final int B = 60;
    private static final int C = 10;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        boolean impossible;
        int a, b, c;
        int t = Integer.parseInt(br.readLine());

        a = t/A;
        b = (t - A*a)/B;
        c = (t - A*a - B*b)/C;
        impossible = (t - A*a - B*b)%C > 0;

        if(impossible) {
            sb.append(-1);
        } else {
            sb.append(a).append(' ').append(b).append(' ').append(c);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
