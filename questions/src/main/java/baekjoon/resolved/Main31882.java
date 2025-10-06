package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main31882 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/31882
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        String line = br.readLine();

        Set<Integer> lengths = new HashSet<>();
        int[] count = new int[1_000_001];
        long sum = 0;
        int thisCount = 0;
        for(int i=0; i<N; i++) {
            int number = line.charAt(i) - '0';
            if(number == 2) {
                thisCount++;
            } else {
                count[thisCount]++;
                lengths.add(thisCount);
                thisCount = 0;
            }
        }
        if(thisCount > 0) {
            count[thisCount]++;
            lengths.add(thisCount);
        }

        for(Integer num : lengths) {
            int c = count[num];
            for(int i=1; i<=num; i++) sum += (long) i*(num-i+1)*c;
        }
        System.out.println(sum);
        br.close();
    }
}
