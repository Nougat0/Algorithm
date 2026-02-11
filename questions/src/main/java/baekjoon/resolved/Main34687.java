package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main34687 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34687
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double n = Double.parseDouble(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        if(m/n >= 0.81) System.out.println("yaho");
        else System.out.println("no");
        
        br.close();
    }
}
