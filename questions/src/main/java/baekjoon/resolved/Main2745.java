package baekjoon.resolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nb = br.readLine().split(" ");
        String n = nb[0];
        int b = Integer.parseInt(nb[1]);
        int decimalNumber = 0;

        //[1] 간단한 버전
        //decimalNumber = Integer.parseInt(n, b);

        //[2] 직접 계산한 버전
        char[] number = n.toCharArray();
        for(int i=0; i<number.length; i++) {
            if(number[i] >= 65 && number[i] <= 90) { //알파벳일 경우
                decimalNumber += Math.pow(b, i) * (number[i] - 55); //A:65->10, Z:90->35
            } else { //숫자일 경우
                decimalNumber += Math.pow(b, i) * (number[i] - '0');
            }
        }
        //출력
        System.out.println(decimalNumber);
    }
}
