package baekjoon.resolved;

import java.io.*;

public class Main4848 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/4848
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder print = new StringBuilder();
        int testCases = Integer.parseInt(br.readLine());
        String[] output = new String[16]; //출력용 배열
        output[0] = "{}";
        for(int i=1; i<=15; i++) {
            StringBuilder string = new StringBuilder();
            string.append(output[0]);
            for(int j=1; j<i; j++) string.append(",").append(output[j]);
            output[i] = "{" + string + "}";
        }
        //입력값으로 연산
        for(int t=0; t<testCases; t++) {
            int sum = 0;
            String s1 = br.readLine();
            String s2 = br.readLine();
            for(int i=0; i<=15; i++) {
                if(s1.equals(output[i])) sum += i;
                if(s2.equals(output[i])) sum += i;
            }
            print.append(output[sum]).append("\n");
        }
        bw.write(print.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
