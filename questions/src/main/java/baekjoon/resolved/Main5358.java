package baekjoon.resolved;

import java.io.*;

public class Main5358 {
    /*
        https://www.acmicpc.net/problem/5358
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //EOF
        String line;
        while((line = br.readLine()) != null) {
            int length = line.length();
            char c;
            for(int i=0; i<length; i++) {
                c = line.charAt(i);
                switch(c) {
                    case 'e': sb.append('i'); break;
                    case 'i': sb.append('e'); break;
                    case 'E': sb.append('I'); break;
                    case 'I': sb.append('E'); break;
                    default: sb.append(c);
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
