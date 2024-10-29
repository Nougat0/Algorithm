package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main18310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //입력
        int houseCnt = Integer.parseInt(br.readLine());
        int[] houses = new int[houseCnt];
        st = new StringTokenizer(br.readLine());
        for(int h=0; h<houseCnt; h++) houses[h] = Integer.parseInt(st.nextToken());
        Arrays.sort(houses); //오름차순 정렬

        //적절한 안테나의 위치 선정
        int houseNo;
        if(houseCnt%2 != 0) //중앙값이 1개일 경우 그대로 사용
            houseNo = houseCnt/2;
        else { //중앙값이 2개일 경우 비교하기
            int case1 = houseCnt/2 - 1, case2 = houseCnt/2;
            long case1Distance = 0, case2Distance = 0;
            for(int h=0; h<houseCnt; h++) {
                case1Distance += Math.abs(houses[h] - houses[case1]);
                case2Distance += Math.abs(houses[h] - houses[case2]);
            }
            //거리가 같을 경우에도 더 작은 값 선택
            if(case1Distance <= case2Distance) houseNo = case1;
            else houseNo = case2;
        }
        //출력
        bw.write(houses[houseNo] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
