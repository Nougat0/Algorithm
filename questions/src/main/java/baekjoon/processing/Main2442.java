package baekjoon.processing;

import java.io.*;

public class Main2442 {
    public static final String star = "*";
    public static final String blank = " ";
    public static final String newLine = "\n";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            for(int j=0; j<n-i; j++) //빈칸 찍기
                sb.append(blank);
            for(int j=0; j<2*i-1; j++) //별 찍기
                sb.append(star);
            sb.append(newLine);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
