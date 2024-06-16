package baekjoon.resolved;

import java.io.*;
import java.util.*;
public class Main2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(checkBags(n) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 가방의 최소 갯수 확인
     * @param n
     * @return 가방갯수, 정수로 맞추지 못할 경우 -1
     */
    private static int checkBags(int n) {
        int max5Bag = n / 5;
        int minBags = 2000;

        for(int i=0; i<=max5Bag; i++) {
            int change = n - 5*i;
            if(change % 3 == 0) {
                if(minBags > i + (change/3)){
                    minBags = i + (change/3);
                }
            }
        }
        return (minBags == 2000 ? -1 : minBags);
    }
}