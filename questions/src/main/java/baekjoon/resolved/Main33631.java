package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main33631 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/33631
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] siumii = new int[4];
        int[] needed = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) siumii[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) needed[i] = Integer.parseInt(st.nextToken());

        Cooking cooking = new Cooking(siumii, needed);

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            cooking.runQuery(no, cnt);
        }
        br.close();
    }

    private static class Cooking {
        final int F = 0;
        final int C = 1;
        final int E = 2;
        final int B = 3;
        int cookies;
        int[] count;
        int[] needed;
        public Cooking(int[] count, int[] needed) {
            this.count = count;
            this.needed = needed;
            this.cookies = 0;
        }

        public void runQuery(int no, int cnt) {
            switch(no) {
                case 1:
                    boolean f = count[F] >= needed[F] * cnt;
                    boolean c = count[C] >= needed[C] * cnt;
                    boolean e = count[E] >= needed[E] * cnt;
                    boolean b = count[B] >= needed[B] * cnt;
                    if(f && c && e && b) {
                        cookies += cnt;
                        count[F] -= (needed[F] * cnt);
                        count[C] -= (needed[C] * cnt);
                        count[E] -= (needed[E] * cnt);
                        count[B] -= (needed[B] * cnt);
                        System.out.println(cookies);
                    }
                    else System.out.println("Hello, siumii");
                    break;
                default:
                    count[no-2] += cnt;
                    System.out.println(count[no-2]);
            }
        }
    }
}
