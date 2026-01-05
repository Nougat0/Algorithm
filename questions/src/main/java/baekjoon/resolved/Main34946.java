package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main34946 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/34946
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int shuttleArrivalIn = Integer.parseInt(st.nextToken());
        int shuttleDuration = Integer.parseInt(st.nextToken());
        int walkDuration = Integer.parseInt(st.nextToken());
        int timeLeft = Integer.parseInt(st.nextToken());

        boolean shuttleIsSavior = timeLeft >= shuttleArrivalIn + shuttleDuration;
        boolean walkingIsSavior = timeLeft >= walkDuration;

        if(shuttleIsSavior && walkingIsSavior) {
            System.out.println("~.~");
        } else if(shuttleIsSavior) {
            System.out.println("Shuttle");
        } else if(walkingIsSavior) {
            System.out.println("Walk");
        } else {
            System.out.println("T.T");
        }
        br.close();
    }
}
