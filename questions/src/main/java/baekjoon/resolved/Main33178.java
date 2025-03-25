package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main33178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        /*10% 할인이므로 10명마다 1개 강의 무료등록*/
        bw.write((n/10) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
