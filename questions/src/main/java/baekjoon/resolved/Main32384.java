package baekjoon.resolved;

import java.io.*;

public class Main32384 {
    public static final String LoveisKoreaUniversity = "LoveisKoreaUniversity";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //입력
        byte n = Byte.parseByte(br.readLine());
        for(byte b=0; b<n; b++) {
            sb.append(LoveisKoreaUniversity);
            if(b<n-1) sb.append(" ");
        }
        //출력
        bw.write(sb.toString());
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
