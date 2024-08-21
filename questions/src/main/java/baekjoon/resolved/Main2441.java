package baekjoon.resolved;

import java.io.*;

public class Main2441 {
    public static final String star = "*";
    public static final String blank = " ";
    public static final String newLine = "\n";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=n; i>0; i--) {
            for(int j=0; j<n-i; j++)
                sb.append(blank);
            for(int j=n-i; j<n; j++)
                sb.append(star);
            sb.append(newLine);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
