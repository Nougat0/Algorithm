package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main5585 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/5585
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int change = 1000 - n;
        int count = 0;
        int[] coinList = new int[]{500, 100, 50, 10, 5, 1};
        for(int coin : coinList) {
            int thisCount = change / coin;
            if(thisCount > 0) {
                change -= coin * thisCount;
                count += thisCount;
            }
        }
        System.out.println(count);
        br.close();
    }
}
