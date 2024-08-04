package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main2845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //상근이의 계산
        StringTokenizer st = new StringTokenizer(br.readLine());
        int population = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        //기사 보도
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()) {
            sb.append(Integer.parseInt(st.nextToken()) - population);
            if(st.hasMoreTokens()) sb.append(" ");
        }
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
    }
}
