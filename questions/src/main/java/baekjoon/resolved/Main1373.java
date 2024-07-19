package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //2진수
        String binaryNumber = br.readLine();
        int length = binaryNumber.length();
        if(length%3 != 0) {//0 채워서 자릿수 맞추기
            binaryNumber = "0".repeat(3 - length%3) + binaryNumber;
            length += 3 - length%3;
        }

        //8진수로 변환하고 바로 출력
        for(int i=0; i<length; i+=3){ //3자리씩 8진수로 변환할 2진수 묶음 만들기
            String binary = new StringBuffer()
                    .append(binaryNumber.charAt(i))
                    .append(binaryNumber.charAt(i+1))
                    .append(binaryNumber.charAt(i+2)).toString();
            //BinaryFromOctal 클래스 활용하여 8진수 값 가져오기
            bw.write(String.valueOf(BinaryFromOctal.getOctal(binary)));
        }

        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 8진수의 각 자릿수를 2진수로 변환하는 용도의 클래스
     */
    public static class BinaryFromOctal {
        private static final Map<String, Integer> octal = new HashMap<>(); //Memoization용 배열 선언
        /*
        binary 를 8진수로 반환
        계산된 값이 octal에 없을 경우, 직접 계산
        */
        public static int getOctal(String binary) {
            if(!octal.containsKey(binary))
                octal.put(binary, calculateOctal(binary));
            return octal.get(binary);
        }
        /*
        8진수 변환 값 계산용 메소드
        */
        public static int calculateOctal(String binary) {
            int octal = 0;
            //8진수 구하기
            for(int i=2; i>=0; i--)
                octal += Math.pow(2, 2-i) *
                        Character.getNumericValue(binary.charAt(i));
            return octal;
        }
    }
}
