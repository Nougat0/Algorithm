package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main18706 {
    /*
        https://www.acmicpc.net/user/bcdlife
        https://www.acmicpc.net/problem/18706
    */
    public static final int SMALL = 0;
    public static final int MEDIUM = 1;
    public static final int LARGE = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=t; testCase++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int deliveryFee = 100 / p;

            int[][] coffeePrice = new int[c][3];
            Map<String, Integer> coffeeIndex = new HashMap<>();

            for(int coffee=0; coffee<c; coffee++) {
                st = new StringTokenizer(br.readLine());
                String coffeeName = st.nextToken();
                int s = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                coffeePrice[coffee][SMALL] = s;
                coffeePrice[coffee][MEDIUM] = m;
                coffeePrice[coffee][LARGE] = l;
                coffeeIndex.put(coffeeName, coffee);
            }
            for(int order=1; order<=p; order++) {
                st = new StringTokenizer(br.readLine());
                sb.append(st.nextToken()); //이름 변수에 담지 말고 바로 사용
                int size = getSize(st.nextToken().charAt(0));
                int coffee = coffeeIndex.get(st.nextToken());
                int price = coffeePrice[coffee][size] + deliveryFee;
                //최종 가격 조정 (할인도 아니고 장사할 생각이 있는 건지
                if(price % 5 == 1) price--;
                else if(price % 5 == 4) price++;
                sb.append(' ').append(price).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getSize(char c) {
        switch(c) {
            case 's': return SMALL;
            case 'm': return MEDIUM;
            default: return LARGE;
        }
    }
}
