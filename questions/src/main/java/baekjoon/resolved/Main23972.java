package baekjoon.resolved;

import java.io.*;
import java.math.*;
import java.util.*;

public class Main23972 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/23972
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigDecimal k = new BigDecimal(st.nextToken());
        BigDecimal n = new BigDecimal(st.nextToken());
        //(x-k) * n >= x
        //xn - kn >= x
        //(n-1) * x >= kn
        //x >= kn/(n-1)

        if(n.compareTo(BigDecimal.ONE) == 0) System.out.println(-1);
        else {
            BigDecimal x = k.multiply(n).divide(n.subtract(BigDecimal.ONE), 0, RoundingMode.UP);
            System.out.println(x);
        }
        br.close();
    }
}
