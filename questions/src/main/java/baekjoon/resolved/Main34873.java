package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main34873 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34873
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] candy = new int[2*n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean possible = true;
        for(int i=1; i<=2*n; i++) {
            int candyNo = Integer.parseInt(st.nextToken());
            int candyCount = candy[candyNo];
            if(candyCount == 2) {
                possible = false;
                break;
            }
            candy[candyNo]++;
        }
        //서로 다른 사탕 N개가 가능한가?
        // 1) 같은 사탕 2개씩 -> N개 이상
        // 2) 다른 사탕 1개씩 -> 2N개 이상
        //사탕은 2N개이므로, 3개 이상인 사탕이 하나라도 존재한다면 불가능...

        bw.write(possible ? "Yes" : "No");
        bw.flush();
        bw.close();
        br.close();
    }
}
