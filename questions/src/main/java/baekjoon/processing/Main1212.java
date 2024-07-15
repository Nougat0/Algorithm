package baekjoon.processing;

import java.io.*;
import java.math.BigInteger;

public class Main1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //8진수
        char[] number = br.readLine().toCharArray();
        //10진수 변환
        BigInteger zero = new BigInteger("0");
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        BigInteger decimal = zero;
        for(int i=0; i<number.length; i++)
            decimal = decimal.add(new BigInteger(
                Character.getNumericValue(number[i]) *
                (int) Math.pow(8, number.length-1-i) + ""
            ));
        //2진수 변환
        String binary = "";
        if(decimal.compareTo(zero) == 0) {
            binary = "0";
        } else {
            while(decimal.divide(two).compareTo(one) == 0 || decimal.divide(two).compareTo(one) == 1) {
                if(decimal.divide(two).compareTo(one) == 0)
                    binary = String.format("%d%d", decimal.divide(two), decimal.remainder(two)) + binary;
                else binary = decimal.remainder(two) + binary;
                decimal = new BigInteger(decimal.divide(two) + "");
            }
        }
        bw.write(binary + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
