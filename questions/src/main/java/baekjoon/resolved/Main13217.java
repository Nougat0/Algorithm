package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main13217 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/13217
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hives = Integer.parseInt(st.nextToken());
        int ml = Integer.parseInt(st.nextToken());
        int tries = Integer.parseInt(st.nextToken());
        long[] hiveHoney = new long[ml + 1];
        for(int i=0; i<hives; i++) {
            int amount = Integer.parseInt(br.readLine());
            // 미리 honeyPot 용량에 맞춰 분리
            if(amount >= ml) {
                int fullCount = amount / ml;
                int remainder = amount % ml;
                hiveHoney[ml] += fullCount;
                hiveHoney[remainder]++;
            } else {
                hiveHoney[amount]++;
            }
        }
        int count = 0;
        long totalAmount = 0;
        int honey = ml;
        while(count < tries && honey > 0) {
            if(hiveHoney[honey] > 0) {
                long usingTimes = Math.min(hiveHoney[honey], tries - count);
                count += usingTimes;
                totalAmount += usingTimes * honey;
            }
            honey--;
        }
        bw.write(totalAmount + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
