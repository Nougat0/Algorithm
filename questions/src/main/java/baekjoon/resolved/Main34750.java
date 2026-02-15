package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main34750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int w = Integer.parseInt(br.readLine());
        int g;
        if(w >= 1_000_000) g = 20;
        else if(w >= 500_000) g = 15;
        else if(w >= 100_000) g = 10;
        else g= 5;
        
        int p;
        sb.append((p = w * g / 100)).append(' ').append(w - p);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
