package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main28113 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int walkToSubway = Integer.parseInt(st.nextToken());
        int busArrival = Integer.parseInt(st.nextToken());
        int subwayArrival = Integer.parseInt(st.nextToken());

        if(walkToSubway > subwayArrival) { //[1] 걸어가도 지하철을 놓치는 경우
            bw.write("Bus");
        } else if(walkToSubway <= subwayArrival) { //[2] 지하철을 탈 수 있음
            if(subwayArrival == busArrival) {
                bw.write("Anything");
            } else if(subwayArrival > busArrival){
                bw.write("Bus");
            } else {
                bw.write("Subway");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
