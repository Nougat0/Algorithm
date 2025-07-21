package baekjoon.resolved;

import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main1340 {
    /*
        time, util 패키지 100% 활용하는 방법
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/1340
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm", Locale.ENGLISH);
        LocalDateTime dateTime = LocalDateTime.parse(br.readLine(), dateFormatter);
        double fullYear = dateTime.toLocalDate().lengthOfYear();
        double daysPassed = dateTime.getDayOfYear() - 1;
        //하루는 1440분
        int hour = dateTime.getHour();
        int minute = dateTime.getMinute();
        //분 단위로 쪼개서 연산하고 출력
        System.out.println((daysPassed * 1440 + (hour*60 + minute)) / (fullYear * 1440) * 100);
        br.close();
    }
}
