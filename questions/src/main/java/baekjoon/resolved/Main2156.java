package baekjoon.resolved;

import java.io.*;

public class Main2156 {
    /*
        https://www.acmicpc.net/problem/2156
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/board/view/45038
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] maxDrink = new int[n+1];
        int[] drink = new int[n+1];
        //2번째까지는 망설임 없이 주어진 모든 포도주를 마셔야 최대값 달성
        for(int i=1; i<=2 && i<=n; i++) {
            drink[i] = Integer.parseInt(br.readLine());
            maxDrink[i] = drink[i] + drink[i-1];
        }
        //3번째부터는 2칸마다 1번 건너뛰는 조건을 만족시켜야 함
        int currBlank, prevBlank, prevPrevBlank;
        for(int i=3; i<=n; i++) {
            drink[i] = Integer.parseInt(br.readLine());
            //1번 건너뛰는 구간이 어디냐에 따라 최대값이 달라짐
            currBlank = maxDrink[i-1] + 0; //i가 구멍
            prevBlank = maxDrink[i-2] + drink[i]; //i-1이 구멍
            prevPrevBlank = maxDrink[i-3] + drink[i-1] + drink[i]; //i-2가 구멍
            //최대값 저장
            maxDrink[i] = Math.max(Math.max(currBlank, prevBlank), prevPrevBlank);
        }
        System.out.println(maxDrink[n]);
        br.close();
    }
}
