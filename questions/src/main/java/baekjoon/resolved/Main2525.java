package baekjoon.resolved;

import java.util.Scanner;

public class Main2525 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/2525
        https://www.acmicpc.net/source/76711054
        2024.04.10
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstLine = sc.nextLine();
        int duration = Integer.parseInt(sc.nextLine());
        int currentHour = Integer.parseInt(firstLine.split(" ")[0]);
        int currentMinute = Integer.parseInt(firstLine.split(" ")[1]);


        if (duration == 0) { // 걸리는 시간 = 0분
            System.out.printf("%d %d%n", currentHour, currentMinute);
        } else { //걸리는 시간을 시간:분 으로 환산하기

            int durationHour = duration / 60;
            int durationMinute = duration % 60;

            int finishMinute = (currentMinute + durationMinute) % 60 ;
            int finishHour = (currentHour + durationHour) + (currentMinute + durationMinute) / 60;

            if(finishHour > 23) finishHour = finishHour - 24;
            System.out.printf("%d %d%n", finishHour, finishMinute);
        }

    }
}