package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main29724 {
    public static final String apple = "A"; //사과박스
    public static final int applePrice = 4000; //사과 개당 시장가격
    public static final int appleBoxWeight = 1000; //특수제작된 사과박스 무게
    public static final int appleSide = 12; //사과의 한 변
    public static final int appleWeight = 500; //사과 무게
    public static final int pearBoxWeight = 120*50; //배박스 무게 (g수*개수)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력 + 연산
        int boxes = Integer.parseInt(br.readLine());
        int totalWeight = 0; //총 질량
        int totalPrice = 0; //총 가격
        StringTokenizer st;
        for(int i=0; i<boxes; i++) {
            st = new StringTokenizer(br.readLine());
            boolean boxType = st.nextToken().equals(apple); //true:사과, false:배
            if(!boxType) totalWeight += pearBoxWeight; //[1] 배박스
            else { //[2] 사과박스
                int apples = 1; //초기화
                //상자의 각 변 별로 사과 들어갈 사과개수 곱셈
                while(st.hasMoreTokens()) apples *= (Integer.parseInt(st.nextToken())/appleSide);
                //총 질량과 가격 계산
                totalWeight += apples*appleWeight + appleBoxWeight;
                totalPrice += apples*applePrice;
            }
        }
        //출력
        bw.write(String.format("%d%n%d%n", totalWeight, totalPrice));
        bw.flush();
        bw.close();
        br.close();
    }
}
