package baekjoon.resolved;

import java.util.*;
import java.io.*;

public class Main11720 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/11720
        https://www.acmicpc.net/source/62075316
        2023.06.14
    */
    public static void main(String[]args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[] num = br.readLine().toCharArray();
        br.close();
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += Character.getNumericValue(num[i]);
        }
        bw.write(sum+"\n");
        bw.flush();
        bw.close();
    }
}