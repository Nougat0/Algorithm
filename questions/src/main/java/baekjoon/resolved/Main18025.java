package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main18025 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/18025
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int days = Integer.parseInt(br.readLine());
        int[] temperature = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int minTemp = 41;
        int start = -1;
        int value; //값 담아놓는 임시 변수
        for(int day=0; day<days; day++) {
            value = Integer.parseInt(st.nextToken());
            if(day < 3) {
                //날짜 채우기
                temperature[day] = value;
            } else {
                //3개 날짜 모두 채워짐 - 옮기기
                temperature[0] = temperature[1];
                temperature[1] = temperature[2];
                temperature[2] = value;
            }
            //온도 계산 시작
            if(day >= 2) {
                value = Math.max(temperature[0], temperature[2]);
                if(value < minTemp) {
                    minTemp = value;
                    start = day-1; //(day+1)-2
                }
            }
        }
        bw.write(start + " " + minTemp);
        bw.flush();
        bw.close();
        br.close();
    }
}
