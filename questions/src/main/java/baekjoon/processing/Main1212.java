package baekjoon.processing;

import java.io.*;

public class Main1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] number = br.readLine().toCharArray(); //8진수
        //10진수 변환
        int decimal = 0;
        for(int i=0; i<number.length; i++) {
            decimal += (int) (Character.getNumericValue(number[i]) * Math.pow(8, number.length-1-i));
        }
        //2진수 변환
        String binary = "";
        if(decimal == 0) {
            binary = "0";
        } else {
            while(decimal/2 >= 1) {
                if(decimal/2 == 1) binary = String.format("%d%d", decimal/2, decimal%2) + binary;
                else binary = decimal%2 + binary;
                decimal /= 2;
            }
        }
        bw.write(binary + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
