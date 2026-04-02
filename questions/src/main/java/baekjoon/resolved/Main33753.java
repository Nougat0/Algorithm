package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main33753 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/33753
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        int fee = a;
        if(t > 30) {
            t -= 30;
            fee += (t/b + (t%b > 0 ? 1 : 0)) * c;
        }
        System.out.println(fee);
        br.close();
    }
}
