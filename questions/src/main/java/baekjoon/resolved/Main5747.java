package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main5747 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/5747
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer blue, red;
        /*
            카드의 순서가 뒤섞인 상태
            따라서 input 카드의 순서는 무의미함
            카드 조합에 따라 가능했을 게임의 판도를 예측 가능
        */
        int n, maryOdd, johnOdd, maryEven, johnEven;
        while((n = Integer.parseInt(br.readLine())) != 0) {
            blue = new StringTokenizer(br.readLine());
            red = new StringTokenizer(br.readLine());
            maryOdd = 0;
            johnOdd = 0;
            for(int i=0; i<n; i++) {
                if(Integer.parseInt(blue.nextToken()) % 2 == 1) maryOdd++;
                if(Integer.parseInt(red.nextToken()) % 2 == 1) johnOdd++;
            }
            maryEven = n - maryOdd;
            johnEven = n - johnOdd;
            /*
                Mary가 이길 수 밖에 없는 게임의 수 확인하기
                John이 Mary의 짝수를 홀수로 무조건 방어 가능한 경우를 제외

                Mary는 홀+홀, 짝+짝을 매칭하고 싶어함
                John은 홀+짝을 매칭하고 싶어함

                전체에서 홀+짝으로 짝지을 수 밖에 없는 게임 개수를 제외하기
                -> mary홀+john짝, mary짝+john홀 경우 제외하기
            */
            sb.append(n - (Math.min(maryOdd, johnEven) + Math.min(johnOdd, maryEven))).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
