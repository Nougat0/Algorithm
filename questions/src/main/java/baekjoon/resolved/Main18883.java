package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main18883 {

    public static final String star = "*";
    public static final String blank = " ";
    public static final String newLine = "\n";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //시간 제한이 타이트해지고, 메모리 제한이 넉넉해짐
        int num = 1;

        //출력
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++) {
                sb.append(num++);
                if(j == m-1) sb.append(newLine);
                else sb.append(blank);
            }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
