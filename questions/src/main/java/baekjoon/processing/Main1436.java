package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        String title = "세상의 종말 ";
        /**
         * n번째 종말숫자를 구할 때까지 반복문 진행
         */
        long number = 0;
        while(count != n) {
            number++;
            if(checkApocalypse(number)) {
                count++;
                System.out.println(number + ":" +count);
            }
        }
        
        bw.write(title + number + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 6이 3개 연속 붙어있는지 확인
     * @param n
     * @return
     */
    private static boolean checkApocalypse(long n) {
        int streak = 0, maxStreak = 0;
        while(n > 0) {
            //연속 6 개수 측정
            if(n % 10 == 6) maxStreak = streak++;
            else streak = 0;
            //6 연속 3개일 경우 바로 true 반환
            if(streak >= 3)  return true;
            n /= 10;
        }
        return false;
    }
}
