package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1297 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        double x = (double) d / Math.sqrt(h*h + w*w);
        System.out.println(h*x);
        System.out.println(w*x);
        //bw.write(String.format("%.0f %.0f%n", h*x, w*x));
        bw.write(String.format("%.0f %.0f%n", Math.floor(h*x), Math.floor(w*x)));
        bw.flush();
        bw.close();
        br.close();
    }
}
