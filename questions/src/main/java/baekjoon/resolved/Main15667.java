package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main15667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int totalFlames = Integer.parseInt(br.readLine());
        // 1 + k + k*k = totalFlames
        // 1 + k*(k+1) = totalFlames
        // k*(k+1) = totalFlames - 1
        int subFlames=1;
        totalFlames--; // = subFlames*(subFlames+1)
        while(subFlames*(subFlames+1) != totalFlames) { subFlames++; }
        bw.write(subFlames + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
