package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main10025 {
    /*
    슬라이딩 윈도우 방식 사용 (브루트 포스랑 비슷하면서 다름)
     */
    public static final int XMAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //입력
        int bucketCnt = Integer.parseInt(st.nextToken());
        int oneArm = Integer.parseInt(st.nextToken());
        int[] buckets = new int[XMAX + 1];
        int xMax = 0, xMin = XMAX;
        for(int i=0; i<bucketCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int ice = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            buckets[x] = ice;
            //탐색할 범위 갱신
            if(x > xMax) xMax = x;
            else if(x < xMin) xMin = x;
        }
        
        long iceMax = 0, currentIce = 0;
        /*
            i를 중심점(앨버트의 위치)으로 간주
            앨버트의 한 팔이 양동이 좌표 절반보다 길 경우 / 짧을 경우 탐색 범위 제한
        */
        int albertMin, albertMax;
        if(oneArm > XMAX/2) {
            albertMin = XMAX/2;
            albertMax = XMAX/2;
            oneArm = XMAX/2;
        }
        else {
            albertMin = xMin+oneArm;
            albertMax = xMax-oneArm;
        }
        //탐색
        for(int i= albertMin; i<=albertMax; i++) {
            //첫 값은 직접 구함
            if(i == albertMin) {
                for(int j=i-oneArm; j<=i+oneArm; j++) {
                    currentIce += buckets[j];
                }
                iceMax = currentIce;
            } 
            //두번째 값부터는 맨앞/맨뒤 값만 제어하여 합산 구하기
            else {
                currentIce -= buckets[i-1-oneArm]; //이전 첫 값 제거
                currentIce += buckets[i+oneArm]; //이번에 추가될 값 추가
                if(currentIce > iceMax) iceMax = currentIce;
            }
        }
        //결과 출력
        bw.write(iceMax + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
