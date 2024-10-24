package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main12185 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        //테스트케이스별로 실행
        for(int t=0; t<testCase; t++) {
            //버스정보 입력
            int numberOfBuses = Integer.parseInt(br.readLine());
            int[][] busRoutes = new int[numberOfBuses][2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int b=0; b<numberOfBuses; b++) { // busRoutes[c][0] <= busRoutes[c][1] 일 것이라 가정
                busRoutes[b][0] = Integer.parseInt(st.nextToken());
                busRoutes[b][1] = Integer.parseInt(st.nextToken());
            }
            //도시정보 입력
            int interestedCities = Integer.parseInt(br.readLine());
            int[] busServes = new int[interestedCities]; //해당 도시에 들르는 버스의 수
            for(int c=0; c<interestedCities; c++) {
                int cityNumber = Integer.parseInt(br.readLine());
                for(int[] route : busRoutes) { //버스정보와 대조
                    if(cityNumber >= route[0] && cityNumber <= route[1]) busServes[c]++;
                }
            }
            if(t!=testCase-1) br.readLine(); //빈 줄 넘기기
            //출력문 생성
            sb.append("Case #").append(t+1).append(":");
            for(int c=0; c<interestedCities; c++) sb.append(" ").append(busServes[c]);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
