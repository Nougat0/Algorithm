package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main27959 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/27959
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if(n * 100 >= m) System.out.println("Yes");
        else System.out.println("No");
        br.close();
    }
}
