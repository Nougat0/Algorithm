package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main13777 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while(true) {
            int rabbitCardNo = Integer.parseInt(br.readLine());
            if(rabbitCardNo == 0) break;
            sb.append(binarySearch(rabbitCardNo)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 이진탐색
     * @param rabbitCardNo 찾을 숫자
     * @return 숫자 찾는 과정의 mid 기록 문자열
     */
    public static String binarySearch(int rabbitCardNo) {
        StringBuilder sb = new StringBuilder();
        int left = 1;
        int right = 50;
        int mid;
        while(left < right) {
            mid = left + (right-left)/2;
            sb.append(mid).append(' '); //mid 체크한 기록
            if(rabbitCardNo == mid) break;
            else if(rabbitCardNo > mid) left = mid+1;
            else right = mid-1;
        }
        return sb.toString();
    }
}
