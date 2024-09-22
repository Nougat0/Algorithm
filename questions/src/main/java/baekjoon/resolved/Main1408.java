package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1408 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        StringTokenizer now = new StringTokenizer(br.readLine(), ":");
        StringTokenizer start = new StringTokenizer(br.readLine(), ":");
        int[] nowTime = new int[3];
        int[] startTime = new int[3];
        for(int i=0; i<3; i++) {
            nowTime[i] = Integer.parseInt(now.nextToken());
            startTime[i] = Integer.parseInt(start.nextToken());
        }
        //연산 + 출력
        bw.write(getTimeDiff(startTime, nowTime));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * nowTime에서 endTime(startTime + 24시간)까지의 남은시간을 구한다.
     * 다음날이면 단순히 시간차이 구하기, 임무시작 당일이라면 24시간에서 흐른시간 빼기
     * @param startTime 임무 시작시간
     * @param nowTime 현재시간
     * @return 시간차이 문자열 (XX:XX:XX)
     */
    public static String getTimeDiff(int[] startTime, int[] nowTime) {
        boolean nextDay; //다음날여부 (24시간에서 시간차를 빼야 하는지 여부)
        int[] former, latter;
        nextDay = checkIsNextDay(startTime, nowTime);
        former = nextDay ? nowTime : startTime;
        latter = nextDay ? startTime : nowTime;

        int second = latter[2] - former[2];
        int minute = latter[1] - former[1];
        int hour = latter[0] - former[0];
        if(second < 0) {
            minute--;
            second += 60;
        }
        if(minute < 0) {
            hour--;
            minute += 60;
        }
        if(!nextDay) { //임무시작 다음날이 아니라면 24시간에서 지나간 시간을 빼기
            second = 60 - second;
            minute = 59 - minute;
            hour = 23 - hour;
        }
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    /**
     * 현재시간이 임무 시작 다음날인지 확인
     * @param startTime 임무 시작시간
     * @param nowTime 현재시간
     * @return 현재시간이 임무 시작시간의 다음날인지 여부
     */
    public static boolean checkIsNextDay(int[] startTime, int[] nowTime) {
        boolean nextDay = false; //다음날여부
        int[] timeCompare = new int[3];
        for(int i=0; i<3; i++) timeCompare[i] = Integer.compare(nowTime[i], startTime[i]);

        if(timeCompare[0] < 0) nextDay = true; //시간에서 더 작을 경우
        else if(timeCompare[0] == 0)
            if(timeCompare[1] < 0) nextDay = true; //분에서 더 작을 경우
            else if(timeCompare[1] == 0 && timeCompare[2] < 0) nextDay = true; //초에서 더 작을 경우
        return nextDay;
    }
}
