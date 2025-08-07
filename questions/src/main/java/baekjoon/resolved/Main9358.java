package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main9358 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/9358
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCases = Integer.parseInt(br.readLine());
        long[] arr = new long[101];
        for(int t=1; t<=testCases; t++) {
            int length = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int index = 0;
            while(st.hasMoreTokens()) {
                arr[index++] = Integer.parseInt(st.nextToken());
            }

            while(length > 2) {
                int ceil = (int) Math.ceil(length/2.0);
                for(index=0; index<ceil; index++) {
                    arr[index] += arr[length-index-1];
                }
                length = ceil;
            }
            sb.append("Case #").append(t).append(": ")
                .append(arr[0] > arr[1] ? "Alice" : "Bob").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
