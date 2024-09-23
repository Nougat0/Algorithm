package baekjoon.processing;

import java.io.*;
import java.util.StringTokenizer;

public class Main1673 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String line;
        while((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            int chickenCnt = 0, stamp = 0;
            int coupon = Integer.parseInt(st.nextToken());
            int stampPerCoupon = Integer.parseInt(st.nextToken());

            while(coupon > 0) {
                chickenCnt += coupon; //갖고 있는 쿠폰으로 치킨 주문
                stamp += coupon; //주문한 개수만큼 도장을 받음
                //쿠폰과 도장 개수 재장전
                coupon = stamp / stampPerCoupon;
                stamp = stamp % stampPerCoupon;
            }
            bw.write(chickenCnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
