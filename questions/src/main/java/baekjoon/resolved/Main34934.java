package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main34934 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34934
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int foundedYear = 0;
        String foundedName = "";
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int year = Integer.parseInt(st.nextToken());
            if(year > foundedYear) {
                foundedYear = year;
                foundedName = name;
            }
        }
        System.out.println(foundedName);
        br.close();
    }
}
