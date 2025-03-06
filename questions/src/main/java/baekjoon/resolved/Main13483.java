package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main13483 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        //사망일 입력 - 연월일 입력
        st = new StringTokenizer(br.readLine());
        int[] dateOfDeath = new int[3];
        for(int i=2; i>=0; i--) {
            dateOfDeath[i] = Integer.parseInt(st.nextToken());
        }
        dateOfDeath[0] -= 18; //만 18살이 될 수 있는 기준
        //아들들 생일 입력 - 연월일 입력
        int sons = Integer.parseInt(br.readLine());
        int[][] dateOfBirth = new int[sons][3];
        for(int s=0; s<sons; s++) {
            st = new StringTokenizer(br.readLine());
            for(int i=2; i>=0; i--) {
                dateOfBirth[s][i] = Integer.parseInt(st.nextToken());
            }
        }
        //적격자 선별
        int sonNumber = -1; //적격자 번호
        int[] birthday = new int[] {1,1,1}; //적격자의 생일, 가장 작은(오래된) 날짜로 초기화
        for(int s=0; s<sons; s++) {
            if(olderOrEqualThan(dateOfBirth[s], dateOfDeath) && olderOrEqualThan(birthday, dateOfBirth[s])) {
                //만 18살 이상 && 현재 가장 어린 적격자보다 어린지 확인
                sonNumber = s+1;
                birthday = dateOfBirth[s];
            }
        }
        bw.write(sonNumber + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     *
     * @param date1
     * @param date2
     * @return date1 날짜가 date2보다 이르거나 같을 경우 true, 늦을의 경우 false
     */
    public static boolean olderOrEqualThan(int[] date1, int[] date2) {
        boolean result = false;
        if(date1[0] < date2[0]) {
            //[1] 연도가 앞설 경우
            result = true;
        } else if(date1[0] == date2[0]) {
            if(date1[1] < date2[1]) {
                //[2] 월이 앞설 경우
                result = true;
            } else if(date1[1] == date2[1] && date1[2] <= date2[2]) {
                //[3] 일이 앞서거나 같은 날짜일 경우
                result = true;
            }
        }
        return result;
    }
}
