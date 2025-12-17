package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2997 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2997
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[3];
        for(int i=0; i<3; i++) {
            int number = Integer.parseInt(st.nextToken());
            num[i] = number;
        }
        Arrays.sort(num);
        int d1 = num[1] - num[0];
        int d2 = num[2] - num[1];
        int ans = -10001;

        if(d2 == d1) ans = num[2] + d2; // N N N X
        else if(d2 > d1) ans = num[1] + d1; // N N X N
        else if(d2 < d1) ans = num[0] + d2; // N X N N

        System.out.println(ans);
        br.close();
    }
}
