package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main11659 {
    /*
        https://www.acmicpc.net/problem/11659
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] accum = new int[n];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<n; index++) accum[index] = (sum += Integer.parseInt(st.nextToken()));

        for(int caseNo=0; caseNo<m; caseNo++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;
            //이중 for문 사용 시 시간초과... 따라서 미리 합산 값을 구해놓고 (누적합) 사용해야 함
            sb.append(accum[j] - (i>0 ? accum[i-1] : 0)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
