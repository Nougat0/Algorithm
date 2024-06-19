package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //Math.pow(99,999999) - Infinity
        long t = Long.parseLong(br.readLine());
        for(long i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int change = a;
            for(int j=1; j<b; j++) {
                change = change*a % 10;
            }

            if(change >= 10) change %= 10;
            if(change == 0) change = 10;

            bw.write(String.format("%d%n", change));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
