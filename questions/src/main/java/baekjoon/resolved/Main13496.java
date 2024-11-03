package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main13496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int shipCnt = Integer.parseInt(st.nextToken());
            //도착가능한 최대위치 = 배의 하루 이동거리 * 남은 계약일수
            int maxDistance = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
            int ducatsRepaid = 0; //갚은 ducat 수
            for(int j=0; j<shipCnt; j++) { //각 배의 위치 + 가진 ducat 수
                st = new StringTokenizer(br.readLine());
                int miles = Integer.parseInt(st.nextToken());
                int shipLoad = Integer.parseInt(st.nextToken());
                if(miles <= maxDistance) ducatsRepaid += shipLoad;
            }
            sb.append("Data Set ").append(i+1).append(":").append("\n").append(ducatsRepaid).append("\n");
            if(i < k-1) sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
