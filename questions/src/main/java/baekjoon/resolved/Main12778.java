package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main12778 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int cases = Integer.parseInt(st.nextToken());
            String type = st.nextToken();

            st = new StringTokenizer(br.readLine()); //문제 입력
            //각 알파벳 or 숫자에 대해 정답 제출
            for(int j=0; j<cases; j++) {
                String question = st.nextToken();
                if(type.equals("C")) sb.append(question.charAt(0) - 64);
                else sb.append((char) (Integer.parseInt(question) + 64));
                sb.append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
