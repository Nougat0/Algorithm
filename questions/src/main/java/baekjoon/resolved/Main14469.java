package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main14469 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/14469
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Cow> cows = new ArrayList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            cows.add(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        //정렬 - 도착시간 오름차순, 같을 시 검역시간 오름차순
        Collections.sort(cows, (cow1, cow2) -> {
            if(cow1.arrival == cow2.arrival) {
                return cow1.processTime - cow2.processTime;
            } else {
                return cow1.arrival - cow2.arrival;
            }
        });
        long time = 0;
        Cow currentCow;
        for(int i=0; i<n; i++) { //loop마다 소의 검역이 끝난 후로 시간을 세팅해놓음
            currentCow = cows.get(i);
            if(time <= currentCow.arrival) {
                //도착하자마자 검역 들어갈 수 있을 때
                time = currentCow.arrival + currentCow.processTime;
            } else if(time > currentCow.arrival) {
                //기다려야 할 때
                time += currentCow.processTime;
            }
        }
        bw.write(time + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Cow {
        int arrival; //도착시간
        int processTime; //검역에 걸리는 시간
        public Cow(int arrival, int processTime) {
            this.arrival = arrival;
            this.processTime = processTime;
        }
    }
}
