package baekjoon.processing;

import java.io.*;
import java.util.*;

public class Main5545 {
    /*
        https://www.acmicpc.net/problem/5545
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int topping_count = Integer.parseInt(br.readLine());
        Integer[] topping_calories = new Integer[topping_count];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dough_price = Integer.parseInt(st.nextToken());
        int topping_price = Integer.parseInt(st.nextToken());
        int dough_calories = Integer.parseInt(br.readLine());
        for(int i=0; i<topping_count; i++) {
            topping_calories[i] = Integer.parseInt(br.readLine());
        }
        //토핑 추가 가격
        //예제 1번 힌트에 토핑 추가 -- 650 칼로리 / 18원 --> 36.1111
        //열량 높은 순서대로 더하고 1원당 칼로리 계산해서 낮아지는 순간에 끊으면 됨
        Arrays.sort(topping_calories, Collections.reverseOrder());
        int price = dough_price;
        int calories = dough_calories;
        int best_pizza = calories / price;
        for(int i=0; i<topping_count; i++) {
            if(best_pizza <= (calories + topping_calories[i]) / (price + topping_price)) {
                calories += topping_calories[i];
                price += topping_price;
                best_pizza = calories / price;
            } else {
                break;
            }
        }
        bw.write(best_pizza + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
