package baekjoon.resolved;

import java.io.*;

public class Main1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //8진수
        char[] number = br.readLine().toCharArray();
        //2진수로 변환 후 바로 출력
        BinaryFromOctal changer = new BinaryFromOctal();
        for(int i=0; i< number.length; i++){
            //BinaryFromOctal 클래스 활용하여 2진수 값 가져오기
            String result = changer.getBinary(Character.getNumericValue(number[i]));
            if(i==0) { //첫번째 숫자의 경우 1) 0인지 확인 및 2) 맨 앞 0 제거
                result = result.replaceAll("^0+", "");
                if(number[i] == '0') result = "0";
            }
            bw.write(result);
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
        private String[] binary = new String[8]; //Memoization용 배열 선언
        /*
        octal 을 2진수로 변환
        계산된 값이 binary에 없을 경우, 직접 계산
        */
        public String getBinary(int octal) {
            if(binary[octal] == null)
                binary[octal] = calculateBinary(octal);
            return binary[octal];
        }
        /*
        2진수 변환 값 계산용 메소드
        */
        public String calculateBinary(int octal) {
            String binary = "";
            if(octal == 0) binary = "0";
            else {
                //2진수 구하기
                while(octal/2 > 0 || octal%2 > 0) {
                    binary = octal%2 + binary;
                    octal /= 2;
                }
            }
            if(binary.length() < 3) //부족한 자릿수 채워넣기
                binary = String.format("%03d", Integer.parseInt(binary));
            return binary;
        }
    }
}
