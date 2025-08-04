package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main31287 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/31287
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        boolean backToOrigin = false;
        long x=0, y=0; //원점
        label:
        for(int loop=0; loop<k; loop++) {
            for(int i=0; i<n; i++) {
                char c = s.charAt(i);
                switch(c) {
                    case 'U': y++; break;
                    case 'D': y--; break;
                    case 'L': x--; break;
                    case 'R': x++; break;
                }
                if(x == 0 && y == 0) {
                    backToOrigin = true;
                    break label;
                }
            }
        }
        bw.write(backToOrigin ? "YES" : "NO");
        bw.flush();
        bw.close();
        br.close();
    }
}
