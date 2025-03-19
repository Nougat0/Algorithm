package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main27968 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int children = Integer.parseInt(st.nextToken());
        int maxGiveaway = Integer.parseInt(st.nextToken());
        long[] giveaway = new long[maxGiveaway]; //누적 나눠주는 합
        st = new StringTokenizer(br.readLine());
        giveaway[0] = Integer.parseInt(st.nextToken());
        for(int m=1; m<maxGiveaway; m++) {
            //M 번째에 누적 몇 개를 나눠줬는지 기록
            giveaway[m] = giveaway[m-1] + Integer.parseInt(st.nextToken());
        }
        //어린이들에게 나눠주기
        while(children-- > 0) {
            long satisfied = Long.parseLong(br.readLine());
            if(satisfied > giveaway[maxGiveaway-1]) { //손목 아프다!
                sb.append("Go away!");
            } else {
                sb.append(binarySearch(giveaway, satisfied));
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 이분탐색 응용... 정확히 일치하는 값이 아닌 범위를 찾기
     * -> while문이 종료된 후의 left + 1 반환
     * @param list 나눠주는 사탕 누적합 배열
     * @param number 만족하는 사탕의 수
     * @return 누적합 배열에서 최소 i 번째로 나눠줘야 만족하는지, i 값을 반환 (인덱스+1)
     */
    public static int binarySearch(long[] list, long number) {
        //이분탐색 구현
        int left = 0; //왼쪽 끝
        int right = list.length - 1; //오른쪽 끝
        int mid; //가운데
        long midValue; //mid 위치의 사탕 누적합

        while(left <= right) {
            mid = left + (right -left) /2; //가운데 인덱스 계산
            midValue = list[mid]; //가운데 누적값
            //반으로 나눠서 탐색
            if(midValue == number)  return mid+1; //가운데 누적합과 동일할 경우 mid+1 횟수
            else if(midValue < number) left = mid + 1; //가운데 누적합보다 클 경우 왼쪽 끝을 mid+1로 지정
            else right = mid - 1; //가운데 누적합보다 작을 경우 오른쪽 끝을 mid-1로 지정
        }
        return left+1; //left+1 횟수만큼 나눠줘야 만족 가능
    }
}
