package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1681 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int students = Integer.parseInt(st.nextToken()); //학생 수
        int banned = Integer.parseInt(st.nextToken()); //금지된 숫자 (0~9)
        //연산 + 출력
        int number = 1;
        for(int i=0; i<students; i++) { //라벨 붙이기
            while(isBanned(number, banned)) number++; //사용 가능한 숫자인지 검증 및 도출
            if(i == students-1) bw.write(number + "\n"); //가장 큰 수의 라벨 출력
            number++; // 다음 라벨 후보
        }
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 금지된 숫자 banned 가 포함된 숫자인지 확인
     * @param currentNumber 검사할 숫자
     * @param banned 금지된 숫자 (0~9)
     * @return 포함되었을 경우 true, 포함되지 않은 숫자일 경우 false;
     */
    public static boolean isBanned(int currentNumber, int banned) {
        while(currentNumber/10 > 0) { //2~N 자릿수 확인
            if(currentNumber%10 == banned) return true;
            currentNumber /= 10;
        }
        if(currentNumber%10 == banned) return true; //1 자릿수 확인
        else return false;
    }
}
