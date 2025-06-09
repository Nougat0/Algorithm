package baekjoon.resolved;

import java.io.*;

public class Main33989 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/contest/problem/1476/6
        https://www.acmicpc.net/problem/33989
    */
    public static final int B = 0;
    public static final int D = 1;
    public static void main(String[] args) throws IOException {
        /*
            처음 짠 코드에서 혼합구간을 구하긴 했지만... 혼합구간은 구획별로 존재할 수 있다
            예를 들어 DBBBBBBBDDDDDDDB 의 경우 혼합구간은 전 구간이지만,
            첫 번째와 마지막 동전, 딱 2개만 바꾸면 올바른 문자열이다.
            이 경우 양끝이 혼합구간, 가운데 부분은 정상구간이라고 봐도 된다...

            결국 특정 위치에 B와 D의 경계선을 만들어야 하고,
            그 경계선의 위치를 순회하면서 뒤집을 게 가장 적은 곳을 찾아봐야 하는 문제인 듯...
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int N = Integer.parseInt(br.readLine());
        char[] coins = br.readLine().toCharArray();
        int[][] sumCoins = new int[N+1][2]; //[B, D] 위치별 누적합 : coins 맨앞 [0,0] 추가됨
        int countB = 0, countD = 0; //누적값 기록용
        int lastB = -1, lastD = -1; //마지막으로 등장하는 곳
        final int FIRST_INDEX = 0;
        final int COINS_LAST_INDEX = N-1;
        //입력
        for(int i=FIRST_INDEX; i<N; i++) {
            char frontCoin = coins[i];
            char backCoin = coins[COINS_LAST_INDEX-i];
            //동전 혼합구간 기록 (최초/마지막 B와 D)
            if(frontCoin == 'B') lastB = i;
            if(backCoin == 'D') lastD = COINS_LAST_INDEX-i;
            //동전 종류별 누적값 기록하기
            if(frontCoin == 'B') countB++;
            else countD++;
            sumCoins[i+1][B] = countB;
            sumCoins[i+1][D] = countD;
        }
        //경계선 결정하기
        if((lastD == -1 || lastB == -1) || (lastB - lastD + 1 == 0)) { //[*] 혼합구간 부재
            bw.write(0 + "\n");
        } else { //[*] 혼합구간 존재 - 최적의 경계선 순회하면서 찾기
            int minChange = N; //최소 변경값 기록
            int change;
            for(int borderLeft=FIRST_INDEX; borderLeft<=N; borderLeft++) {
                //[borderLeft] (경계선) [borderLeft + 1]
                //왼쪽의 D, 오른쪽의 B를 모두 변경
                change = sumCoins[borderLeft][D] + (sumCoins[N][B] - sumCoins[borderLeft][B]);
                if(change < minChange) minChange = change;
            }
            bw.write(minChange + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}