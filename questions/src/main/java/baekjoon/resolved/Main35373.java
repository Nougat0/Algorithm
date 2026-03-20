package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main35373 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/35373
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int s = 0, m = 0, l = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String size = st.nextToken();
            int leftOver = Integer.parseInt(st.nextToken());
            switch(size) {
                case "S": s += leftOver; break;
                case "M": m += leftOver; break;
                case "L": l += leftOver; break;
            }
        }
        int sum = 0;
        sum += (s/6 + m/8 + l/12);
        sum += ((s%6 > 0 ? 1 : 0) + (m%8 > 0 ? 1 : 0) + (l%12 > 0 ? 1 : 0));
        System.out.println(sum);
        br.close();
    }
}
