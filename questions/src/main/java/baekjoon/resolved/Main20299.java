package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main20299 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/20299
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringBuilder team;
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int signUp = 0;
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            boolean everyoneCanSignUp = true;
            team = new StringBuilder();
            while(st.hasMoreTokens()) {
                int rating = Integer.parseInt(st.nextToken());
                if(rating < l) {
                    everyoneCanSignUp = false;
                    break;
                } else {
                    team.append(rating).append(' ');
                    sum += rating;
                }
            }
            if(everyoneCanSignUp && sum >= k) {
                sb.append(team);
                signUp++;
            }
        }
        bw.write(signUp + "\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
