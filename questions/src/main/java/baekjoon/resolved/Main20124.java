package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main20124 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/20124
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String name, elect = "";
        int score, electScore = 0;
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            score = Integer.parseInt(st.nextToken());

            if(score > electScore || (score == electScore && name.compareTo(elect) < 0)) {
                electScore = score;
                elect = name;
            }
        }
        System.out.println(elect);
        br.close();
    }
}
