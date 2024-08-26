package baekjoon.processing;

import java.io.*;

public class Main10990 {
    public static final String star = "*";
    public static final String blank = " ";
    public static final String newLine = "\n";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            //첫번째 별 찍기
            for(int j=0; j<n-i-1; j++) //앞의 빈칸
                sb.append(blank);
            sb.append(star);
            //두번째 별 찍기
            for(int j=0; j<2*i-1; j++) //가운데 빈칸
                sb.append(blank);
            if(i!=0)
                sb.append(star);
            sb.append(newLine);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
