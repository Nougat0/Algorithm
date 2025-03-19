package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main21867 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[] line = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        int jvaCount = 0; //JAV 개수
        for(int i=0; i<n; i++) {
            switch(line[i]) {
                case 'J': case 'V': case 'A': jvaCount++; break;
                default: sb.append(line[i]);
            }
        }
        if(jvaCount == n) { //sb.length 보다 낫지 않을까 하는 생각..
            bw.write("nojava");
        } else {
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
