package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main15552 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/15552
        https://www.acmicpc.net/source/62073750
        2023.06.14
    */
    public static void main(String[]args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            String[] line = br.readLine().split(" ");
            bw.write(Integer.parseInt(line[0])+Integer.parseInt(line[1])+ "\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}