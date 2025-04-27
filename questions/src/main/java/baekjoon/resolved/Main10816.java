package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] nCards = new int[20_000_001];
        st = new StringTokenizer(br.readLine());
        while(n-- > 0) {
            int number = Integer.parseInt(st.nextToken());
            nCards[number + 10_000_000]++;
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(m-- > 0) {
            int number = Integer.parseInt(st.nextToken());
            int count = nCards[number + 10_000_000];
            sb.append(count).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
