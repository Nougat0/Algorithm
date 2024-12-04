package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main5666 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        while((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            int hotDogs = Integer.parseInt(st.nextToken());
            int participants = Integer.parseInt(st.nextToken());
            sb.append(String.format("%.2f%n", (double) hotDogs / participants));
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
