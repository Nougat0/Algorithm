package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main10886 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int result = 0;
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++) {
            if(Integer.parseInt(br.readLine()) == 1) result++;
            else result--;
        }
        sb.append("Junhee is");
        sb.append(result < 0 ? " not " : " ");
        sb.append("cute!");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
