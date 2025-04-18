package baekjoon.resolved;

import java.io.*;

public class Main2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 7;
        boolean isEven, onlyEvenNumbers = true;
        int minOdd = 99, oddSum = 0;
        int number;
        while(count-- > 0) {
            number = Integer.parseInt(br.readLine());
            isEven = number % 2 == 0;
            onlyEvenNumbers &= isEven;
            if(!isEven) {
                oddSum += number;
                if(number < minOdd) {
                    minOdd = number;
                }
            }
        }
        if(onlyEvenNumbers) {
            sb.append(-1);
        } else {
            sb.append(oddSum).append("\n").append(minOdd);
        }
        System.out.println(sb);
        br.close();
    }
}
