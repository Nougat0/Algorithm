package baekjoon.resolved;

import java.io.*;

public class Main31746 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/31746
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n % 2 == 0) System.out.println("SciComLove");
        else System.out.println("evoLmoCicS");
        br.close();
    }
}
