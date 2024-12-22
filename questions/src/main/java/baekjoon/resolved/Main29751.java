package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main29751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //가로길이와 높이 입력
        double w = Double.parseDouble(st.nextToken());
        double h = Double.parseDouble(st.nextToken());
        bw.write(String.format("%.1f", w*h/2));
        bw.flush();
        bw.close();
        br.close();
    }
}
