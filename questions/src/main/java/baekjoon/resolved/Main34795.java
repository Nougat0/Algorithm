package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main34795 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34795
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double m = Double.parseDouble(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        System.out.println((int) Math.ceil(d/m));
        br.close();
    }
}
