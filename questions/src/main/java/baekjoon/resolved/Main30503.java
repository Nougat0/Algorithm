package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main30503 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/30503
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int length = Integer.parseInt(br.readLine());
        int[] quadrat = new int[length+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=length; i++) quadrat[i] = Integer.parseInt(st.nextToken());
        int queries = Integer.parseInt(br.readLine());
        for(int q=0; q<queries; q++) {
            st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("1")) { //조사 및 출력
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                int count = 0;
                for(int i=l; i<=r; i++)
                    if(quadrat[i] == k) count++;
                sb.append(count).append("\n");
            } else { //밟아 없애기
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                for(int i=l; i<=r; i++)
                    quadrat[i] = 0;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
