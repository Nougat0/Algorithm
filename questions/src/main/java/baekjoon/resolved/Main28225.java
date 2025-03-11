package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main28225 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cars = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());
        double minArrivalTime = distance + 1;
        int minCarNo = -1;
        //차량별로 시간 계산
        for(int i=0; i<cars; i++) {
            st = new StringTokenizer(br.readLine());
            int location = Integer.parseInt(st.nextToken());
            double speed = Double.parseDouble(st.nextToken());
            double arrivalTime = (distance-location)/speed;
            //더 빨리 도착하는 경우 min값 갱신
            if(arrivalTime < minArrivalTime) {
                minArrivalTime = arrivalTime;
                minCarNo = i+1;
            }
        }
        bw.write(minCarNo + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
