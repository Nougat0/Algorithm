package baekjoon.processing;

import java.io.*;
import java.util.*;
import java.time.*;

public class Main1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Instant t1 = null;
        Instant t2 = null;


        //입력
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            t1 = Instant.now();
            /*
            경우의 수이기 때문에 for문 안에서 할 것은 별로 없다... 그냥 더하기 연산 하면 될 듯
            a개 횟수만큼 재귀 depth 가 결정되고
            b만큼 for문 반복횟수가 많아짐
            */
            int count = countRecursive(1, n, m, 0);
            t2 = Instant.now();
            bw.write(String.format("%d 걸린시간:%s%n", count, Duration.between(t1, t2).toMillis()));
        }
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * @param depth 최대값 n을 가진다
     * @param n 다리의 개수. 모든 재귀함수 실행문에서 동일하게 갖고 있는 값
     * @param m 다음 재귀 for문 최대값
     * @param count
     * @return
     */
    public static int countRecursive(int depth, int n, int m, int count) {
        int depthCount = 0; //해당 depth의 경우의 수

        if(depth == n) //최종 layer라면 for문 없이 경우의 수 구해서 올려보내기
            count += (m - (n-depth+1) + 1);
        else //최종 layer가 아니라면 for문으로 더 깊이 들어가기 -> 올려보내진 count값들 담기
            for(int i=n-depth+1; i<=m; i++)
                depthCount += countRecursive(depth+1, n, i-1, count);
        return count + depthCount;
    }
}
