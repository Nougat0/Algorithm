package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2083 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if(name.charAt(0) == '#') break;
            sb.append(name).append(' ');

            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(age > 17 || weight >= 80) sb.append("Senior");
            else sb.append("Junior");

            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
