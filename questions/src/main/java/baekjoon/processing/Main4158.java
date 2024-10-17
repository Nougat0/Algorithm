package baekjoon.processing;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main4158 {
    public static final int maxCDNo = 1000000000; //CD 번호 최대값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String testCase;
        while(!(testCase = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(testCase);
            int sangCDs = Integer.parseInt(st.nextToken());
            int sunCDs = Integer.parseInt(st.nextToken());
            boolean[] sangCDList = new boolean[maxCDNo];
            boolean[] sunCDList = new boolean[maxCDNo];
            for(int i=0; i<sangCDs; i++) sangCDList[Integer.parseInt(br.readLine())] = true;
            for(int i=0; i<sunCDs; i++) sunCDList[Integer.parseInt(br.readLine())] = true;

            int sameCDs = 0;
            for(int i=0; i<maxCDNo; i++) if(sangCDList[i] && sunCDList[i]) sameCDs++;
            bw.write(sameCDs + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
