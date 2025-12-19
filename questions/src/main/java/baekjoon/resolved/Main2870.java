package baekjoon.resolved;

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main2870 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2870
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<BigInteger> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            StringTokenizer ss = new StringTokenizer(br.readLine(), "abcdefghijklmnopqrstuvwxyz");
            while(ss.hasMoreTokens()) {
                list.add(new BigInteger(ss.nextToken()));
            }
        }
        Collections.sort(list);
        int numbers = list.size();
        for(int i=0; i<numbers; i++) {
            sb.append(list.get(i)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
