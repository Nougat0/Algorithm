package baekjoon.resolved;

import java.io.*;

public class Main2193 {
    /*
        https://www.acmicpc.net/problem/2193
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        //배열 대신 직전값 저장변수만 사용
        long zeroEndNumCnt = 0;
        long oneEndNumCnt = 1;
        long zeroEnds, oneEnds;
        for(int i=2; i<=n; i++) {
            zeroEnds = zeroEndNumCnt + oneEndNumCnt;
            oneEnds = zeroEndNumCnt;
            //계산값 담기(재할당)
            zeroEndNumCnt = zeroEnds;
            oneEndNumCnt = oneEnds;
        }
        System.out.println(zeroEndNumCnt + oneEndNumCnt);
        br.close();
    }
}
