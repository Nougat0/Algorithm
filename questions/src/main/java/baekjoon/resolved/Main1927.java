package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1927 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/1927
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            int number = Integer.parseInt(br.readLine());
            if(number == 0) {
                sb.append(minHeap.isEmpty() ? 0 : minHeap.poll())
                    .append("\n");
            } else {
                minHeap.add(number);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
