package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int callCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] callList = new int[callCnt]; //초 단위

        int ySum = 0, mSum = 0;
        for(int i=0; i<callCnt; i++) {
            callList[i] = Integer.parseInt(st.nextToken());
            ySum += (callList[i] / 30 + 1) * 10;
            mSum += (callList[i] / 60 + 1) * 15;
        }

        if(ySum > mSum)
            bw.write(String.format("%s %d%n", "M", mSum));
        else if(ySum == mSum)
            bw.write(String.format("%s %d%n", "Y M", mSum));
        else
            bw.write(String.format("%s %d%n", "Y", ySum));
        bw.flush();
        bw.close();
        br.close();
    }
}
