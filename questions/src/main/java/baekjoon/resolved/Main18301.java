package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main18301 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/18301
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        double n12 = Double.parseDouble(st.nextToken());
        int result = (int) Math.floor((n1+1)*(n2+1)/(n12+1) - 1);
        System.out.println(result);
        br.close();
    }
}
