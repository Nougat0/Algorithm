package baekjoon.resolved;

import java.io.*;

public class Main10820 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/10820
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = br.readLine()) != null) {
            int length = line.length();
            int[] count = new int[4];
            for(int i=0; i<length; i++) {
                char c = line.charAt(i);
                //소문자97~ 대문자65~ 숫자48~ 공백32
                if(c >= 'a') count[0]++;
                else if(c >= 'A') count[1]++;
                else if(c >= '0') count[2]++;
                else count[3]++;
            }
            //출력
            for(int i=0; i<4; i++) {
                if(i > 0) sb.append(' ');
                sb.append(count[i]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
