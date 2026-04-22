package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main20502 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/20502
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] rank = new int[n+1];
        List[] key = new ArrayList[m+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            rank[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for(int j=0; j<count; j++) {
                int keyword = Integer.parseInt(st.nextToken());
                if(key[keyword] == null) key[keyword] = new ArrayList();
                key[keyword].add(i);
            }
        }

        int q = Integer.parseInt(br.readLine());
        for(int i=0; i<q; i++) {
            int keyword = Integer.parseInt(br.readLine());
            if(key[keyword] == null) sb.append(-1);
            else {
                Collections.sort(key[keyword], Comparator.comparingInt(page -> rank[(int) page]));
                int size = key[keyword].size();
                for(int j=0; j<size; j++) {
                    sb.append(key[keyword].get(j)).append(' ');
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
