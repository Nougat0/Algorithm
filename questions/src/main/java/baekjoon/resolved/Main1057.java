package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());
        /*
        그냥 kim과 lim의 바뀌는 번호를 추적하면 될 듯
        이번판 안 만나면 다음판 번호 구하기
        테스트해보니 부전승의 경우도 해결됨
         */
        int round = 1;
        while(!meetsThisRound(n, kim, lim)) {
            kim = getNextNumber(n, kim);
            lim = getNextNumber(n, lim);
            n = n/2;
            round++;
        }
        bw.write(round + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getNextNumber(int n, int number) {
        if(number % 4 == 0) return number/4 * 2;
        else if(number % 4 == 1 || number % 4 == 2) return number / 4 * 2 + 1;
        else return number / 4 * 2 + 2;
    }

    public static boolean meetsThisRound(int n, int number1, int number2) {
        int min = Math.min(number1, number2);
        int max = Math.max(number1, number2);

        if(min/2 + 1 == max/2 && Math.abs(min - max) == 1) return true;
        else return false;
    }
}
