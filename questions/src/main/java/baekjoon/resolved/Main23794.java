package baekjoon.resolved;

import java.io.*;

public class Main23794 {
    public static final String at = "@";
    public static final String blank = " ";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int rectSize = n+2; //한 변의 크기
        StringBuilder sb = new StringBuilder();

        sb.append(at.repeat(rectSize) + "\n"); //첫째줄
        for(int i=1; i<rectSize-1; i++) //둘째줄 ~ n+1줄
            sb.append(at + blank.repeat(n) + at + "\n");
        sb.append(at.repeat(rectSize) + "\n"); //n+2줄

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
