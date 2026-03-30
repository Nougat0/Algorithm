package baekjoon.resolved;

import java.io.*;

public class Main35423 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/35423
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        int formerCount = 0;
        int latterCount = 0;
        int length = line.length();
        for(int i=0; i<length; i++) {
            char c = line.charAt(i);
            if(c == 'S') formerCount++;
            else if(c == 'L') latterCount++;
        }
        for(int i=0; i<formerCount; i++) {
            sb.append("SciCom");
        }
        for(int i=0; i<latterCount; i++) {
            sb.append("Love");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
