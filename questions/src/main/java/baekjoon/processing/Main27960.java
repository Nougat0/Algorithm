package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main27960 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/27960
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] aShot = getShotList(a);
        boolean[] bShot = getShotList(b);

        int c = 0;
        for(int i=0; i<10; i++) {
            if(aShot[i] ^ bShot[i]) {
                c += biPow(i);
            }
        }
        System.out.println(c);
        br.close();
    }

    public static boolean[] getShotList(int score) {
        boolean[] shot = new boolean[10];
        for(int i=9; i>=0; i--) {
            int pow = biPow(i);
            if(score > pow) {
                score -= pow;
                shot[i] = true;
            }
        }
        return shot;
    }

    // Math.pow 로 double 결과 받는 게 싫어서 직접 만들어 사용함
    public static int biPow(int exponent) {
        int result = 1;
        while(exponent-- > 0) {
            result *= 2;
        }
        return result;
    }
}
