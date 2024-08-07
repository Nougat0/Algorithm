package baekjoon.processing;

import java.io.*;

public class Main1284 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) { //testcase 별로 출력하기
            int number = Integer.parseInt(br.readLine());
            if(number == 0) break;

            int totalLength = 2; //호수판의 경계와 숫자 사이 여백으로 초기화
            while(number/10 > 0) { //숫자의 각 자리별로 너비 확인
                //숫자별 너비 추가
                totalLength += getLength(number%10);
                totalLength += 1; //숫자 사이 간격 추가
                number /= 10;
            }
            //마지막 1의 자릿수 추가
            totalLength += getLength(number);
            //출력
            bw.write(totalLength + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    //숫자별 너비 반환하는 함수
    public static int getLength(int number) {
        if(number == 1) return 2;
        else if(number == 0) return 4;
        else return 3;
    }
}
