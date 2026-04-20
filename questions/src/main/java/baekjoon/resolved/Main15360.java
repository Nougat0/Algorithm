package baekjoon.resolved;

import java.io.*;

public class Main15360 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/15360
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine()); // 1~length
        int lights = Integer.parseInt(br.readLine());
        int updown = Integer.parseInt(br.readLine());
        final int range = updown == 0 ? 1 : (updown*2 + 1);
        int covered = 0;
        int neededTotal = 0;
        for(int i=0; i<lights; i++) {
            int position = Integer.parseInt(br.readLine());
            int min = position - updown;
            int max = position + updown;
            if(min - covered > 1) {
                //비어있는 공간 너비 계산
                int distance = min - covered - 1;
                int neededCount = distance / range + (distance % range > 0 ? 1 : 0);
                neededTotal +=  neededCount;
            }
            covered = max;
        }
        //마지막 가로등과 거리의 끝 비교
        if(length > covered) {
            //비어있는 공간 너비 계산
            int distance = length - covered;
            int neededCount = distance / range + (distance % range > 0 ? 1 : 0);
            neededTotal += neededCount;
        }
        System.out.println(neededTotal);
        br.close();
    }
}
