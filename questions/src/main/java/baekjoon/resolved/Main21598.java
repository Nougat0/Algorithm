package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main21598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) sb.append("SciComLove\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
