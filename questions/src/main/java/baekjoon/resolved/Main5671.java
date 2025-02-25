package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main5671 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        //테스트 케이스
        while((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            int min = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());
            int rooms = 0;
            for(int i=min; i<=max; i++) {
                if(checkUsable(i)) {
                    rooms++;
                }
            }
            sb.append(rooms).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 사용가능한 호실 번호인지 확인
     * (중복되는 1의 자리 숫자 존재하는지 확인)
     * @param n
     * @return 중복존재: false, 중복없음: true
     */
    public static boolean checkUsable(int n) {
        boolean[] numbers = new boolean[10];
        //10~ 의 자리 체크
        while(n/10 > 0) {
            int number = n % 10;
            if(numbers[number]) {
                return false;
            } else {
                numbers[number] = true;
            }
            n /= 10;
        }
        //마지막 남은 1의 자리 체크
        if(numbers[n]) {
            return false;
        } else {
            return true;
        }
    }
}
