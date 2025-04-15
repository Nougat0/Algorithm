package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main4470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int lines = Integer.parseInt(br.readLine());
        for(int i=1; i<=lines; i++) {
            sb.append(i).append(". ").append(br.readLine()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
