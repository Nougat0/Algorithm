package baekjoon.resolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int num1 = revertedNumber(input[0]);
        int num2 = revertedNumber(input[1]);

        //상수의 대답
        System.out.println(Math.max(num1, num2));
    }

    public static int revertedNumber(String number) {
        String reverted = "";
        char[] arr = number.toCharArray();
        for(int i=arr.length-1; i>=0; i--) {
            reverted += Character.toString(arr[i]);
        }
        return Integer.parseInt(reverted);
    }
}
