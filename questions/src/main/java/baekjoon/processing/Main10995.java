package baekjoon.processing;

import java.io.*;

public class Main10995 {
    public static final String star = "*";
    public static final String blank = " ";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!(i%2==0 && j==0)) bw.write(blank); //홀수줄+맨앞에서만 안 찍기.
                bw.write(star);
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
