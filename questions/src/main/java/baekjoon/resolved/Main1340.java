package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1340 {
    /*
        직접 구현하는 방법
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/1340
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //MMMM dd, yyyy HH:mm
        StringTokenizer st = new StringTokenizer(br.readLine());
        int month = Month.valueOf(st.nextToken()).ordinal() + 1;
        int day = Integer.parseInt(st.nextToken().replace(",", ""));
        int year = Integer.parseInt(st.nextToken());
        String[] time = st.nextToken().split(":");
        boolean isLeapYear = isLeapYear(year);
        double fullYear = 365; //기본 일수
        double daysPassed = 0;
        //윤년일 시 확인 (윤달 +1)
        if(isLeapYear) {
            if(month > 2) daysPassed++;
            fullYear++;
        }
        //지나간 월별 일수
        for(int m=1; m<month; m++) {
            if(m == 4 || m == 6 || m == 9 || m == 11) daysPassed += 30;
            else if(m == 2) daysPassed += 28;
            else daysPassed += 31;
        }
        //지나간 이번달 일수
        daysPassed += (day - 1);
        //지나간 오늘 시간(분)
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        //분 단위로 쪼개서 연산하고 출력
        System.out.println((daysPassed * 1440 + (hour*60 + minute)) / (fullYear * 1440) * 100);
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
    //MMMM -> 숫자로 변환하기 위한 enum
    public enum Month {
        January, February, March, April, May, June, July, August, September, October, November, December
    }
}
