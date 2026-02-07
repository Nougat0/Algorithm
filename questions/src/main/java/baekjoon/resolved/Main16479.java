package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main16479 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/16479
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double d1 = Integer.parseInt(st.nextToken()) / 2.0;
        double d2 = Integer.parseInt(st.nextToken()) / 2.0;
        double ans;
        if(d1 == d2) ans = k*k;
        else {
            double abs = Math.abs(d1-d2);
            ans = k*k - abs*abs;
        }
        boolean isInteger = ans % 1 == 0.0;
        int errorDecimal = isInteger ? 0 : 6;
        System.out.println(String.format("%."+errorDecimal+"f", ans));
        br.close();
    }
}
