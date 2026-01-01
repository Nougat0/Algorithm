package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main4749 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/4749
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder provided = new StringBuilder();
        StringBuilder lacking = new StringBuilder("Provides no significant amount of:\n");
        StringTokenizer st;
        double a;
        String unit;
        double r;
        String name;

        while(true) {
            st = new StringTokenizer(br.readLine());
            a = Double.parseDouble(st.nextToken());
            unit = st.nextToken();
            r = Double.parseDouble(st.nextToken());
            name = "";
            while(st.hasMoreTokens()) {
                name += (st.nextToken() + " ");
            }

            if(a < 0) break; //EOF

            double percent = a / r * 100;
            if(percent >= 1.0) {
                provided.append(name).append(a).append(' ').append(unit).append(' ')
                        .append(String.format("%.0f", percent)).append("%\n");
            } else {
                lacking.append(name).append("\n");
            }
        }
        bw.write(provided.toString());
        bw.write(lacking.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
