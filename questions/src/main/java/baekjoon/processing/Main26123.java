package baekjoon.processing;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main26123 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int buildingCnt = Integer.parseInt(st.nextToken());
        int days = Integer.parseInt(st.nextToken());
        long laser = 0, dayCnt = 0, temp;

        long[] buildings = new long[300001]; // 1~300,000
//        boolean[] heights = new boolean[300000];
        int maxHeight = 0, building, index = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<buildingCnt; i++) {
            building = Integer.parseInt(st.nextToken());
            buildings[building]++;
            if(building > maxHeight) {
                maxHeight = building;
            }
        }
        index = maxHeight;
        while(dayCnt <= days && index > 0) {
            days++;
            temp = buildings[index];
            laser += temp;

            index--;
        }
        bw.write(buildings[index] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
