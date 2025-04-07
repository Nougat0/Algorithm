package baekjoon.resolved;

import java.io.*;

public class Main15439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(n*(n-1)); //조합
        br.close();
    }
}
