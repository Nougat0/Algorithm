package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main2139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        /**
         * 올해의 며칠째 날짜인지 파악
         */
        while(true) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            if(day == 0 && month == 0 && year == 0) break;

            boolean isLeapYear = isLeapYear(year);
            int countDays = 0;
            for(int i=1; i<month; i++) { //이번달 전까지의 날짜 수
                if(i == 4 || i == 6 || i == 9 || i == 11) countDays += 30;
                else if(i == 2) countDays += 28;
                else countDays += 31;
            }
            countDays += day; //이번달 날짜 수
            if(isLeapYear && month > 2) countDays++; //윤년 +1
            sb.append(countDays).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 윤년인지 체크
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year) {
        boolean isLeapYear = false;
        if(year % 4 == 0) isLeapYear = true;
        if(year % 100 == 0) isLeapYear = false;
        if(year % 400 == 0) isLeapYear = true;
        return isLeapYear;
    }
}
