package baekjoon.resolved;

import java.io.*;

public class Main10953 {
    /*
        https://www.acmicpc.net/problem/10953
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String line;
        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0) {
            line = br.readLine();
            //1~9까지의 값만 A, B로 주어짐 (한자릿수)
            int a = Character.getNumericValue(line.charAt(0));
            int b = Character.getNumericValue(line.charAt(2));
            sb.append(a+b).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
