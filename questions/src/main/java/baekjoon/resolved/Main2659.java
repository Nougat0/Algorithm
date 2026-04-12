package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2659 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2659
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = 0;
        int clockNumber;
        for(int i=3; i>=0; i--) {
            number += Math.pow(10, i) * Integer.parseInt(st.nextToken());
        }
        clockNumber = getClockNumber(number);

        /**
         * 생각해보니 굳이 시계수 후보를 선별 + contains를 할 필요까지는 없을 듯
         * 그냥 선별해보고... 더 작은 수가 나오면 false
         */
        int count = 1;
        for(int cn=1111; cn<clockNumber; cn++) {
            if(hasZero(cn) || getClockNumber(cn) != cn) continue;
            count++;
        }
        System.out.println(count);
        br.close();
    }

    public static boolean hasZero(int cn) {
        while(cn / 10 > 0) {
            if(cn % 10 == 0) return true;
            else cn /= 10;
        }
        if(cn % 10 == 0) return true;
        return false;
    }

    public static int getClockNumber(int cn) {
        int clockNumber = cn;
        int candidate = cn;
        for(int i=1; i<=3; i++) {
            // 마지막 숫자를 떼어서 맨앞으로 옮기기
            int lastNumber = candidate % 10;
            candidate /= 10;
            candidate += lastNumber * 1000;

            if(candidate < clockNumber) {
                clockNumber = candidate;
            }
        }
        return clockNumber;
    }
}
