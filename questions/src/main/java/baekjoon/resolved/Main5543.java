package baekjoon.resolved;

import java.io.*;

public class Main5543 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/5543
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int burger = 3_000;
        int drink = 3_000;
        for(int i=0; i<3; i++) burger = Math.min(burger, Integer.parseInt(br.readLine()));
        for(int i=0; i<2; i++) drink = Math.min(drink, Integer.parseInt(br.readLine()));
        System.out.println(burger + drink - 50);
        br.close();
    }
}
