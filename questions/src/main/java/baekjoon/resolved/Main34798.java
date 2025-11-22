package baekjoon.resolved;

import java.io.*;

public class Main34798 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34798
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] alarm = br.readLine().toCharArray();
        char[] woken = br.readLine().toCharArray();
        int alarmHour = 10 + (alarm[1] - '0');
        int alarmMinute = (alarm[3] - '0') * 10 + (alarm[4] - '0');

        int wokenHour = 10 + (woken[1] - '0');
        int wokenMinute = (woken[3] - '0') * 10 + (woken[4] - '0');

        if(alarmHour < wokenHour || alarmHour == wokenHour && alarmMinute < wokenMinute)
            System.out.println("YES");
        else System.out.println("NO");
        br.close();
    }
}
