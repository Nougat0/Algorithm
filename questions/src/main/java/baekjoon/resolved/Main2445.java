package baekjoon.resolved;

import java.io.*;

public class Main2445 {
    public static final String star = "*";
    public static final String blank = " ";
    public static final String newLine = "\n";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) //별 찍기
                sb.append(star);
            for(int j=i; j<2*n-i; j++) //빈칸 찍기
                sb.append(blank);
            for(int j=0; j<i; j++) //별 찍기
                sb.append(star);
            sb.append(newLine);
        }
        for(int i=0; i<2*n; i++) //가운데 줄 찍기
            sb.append(star);
        sb.append(newLine);
        for(int i=n; i>0; i--) {
            for(int j=1; j<i; j++) //별 찍기
                sb.append(star);
            for(int j=2*n-i; j>i-2; j--) //빈칸 찍기
                sb.append(blank);
            for(int j=1; j<i; j++) //별 찍기
                sb.append(star);
            sb.append(newLine);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
