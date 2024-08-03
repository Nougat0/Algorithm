package baekjoon.resolved;

import java.io.*;

public class Main2154 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) sb.append(i); //문자열 만들기
        //출력
        bw.write(sb.indexOf(String.valueOf(n))+1 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
