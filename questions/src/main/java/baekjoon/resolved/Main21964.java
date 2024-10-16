package baekjoon.resolved;

import java.io.*;

public class Main21964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //입력 및 출력문 생성
        int length = Integer.parseInt(br.readLine());
        char[] line = br.readLine().toCharArray();
        for(int i=5; i>=1; i--) sb.append(line[length-i]);
        //출력
        bw.write(sb.toString());
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
