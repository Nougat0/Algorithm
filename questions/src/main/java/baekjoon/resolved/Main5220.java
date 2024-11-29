package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main5220 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int t=0; t<testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int data = Integer.parseInt(st.nextToken());
            char[] binaryData = Integer.toBinaryString(data).toCharArray();
            //1은 true, 0은 false
            boolean check = Integer.parseInt(st.nextToken()) == 1;
            boolean isOdd = false;
            for(int i=0; i<binaryData.length; i++) {
                if(binaryData[i] == '1') isOdd = !isOdd;
            }
            if(isOdd == check) sb.append("Valid\n");
            else sb.append("Corrupt\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
