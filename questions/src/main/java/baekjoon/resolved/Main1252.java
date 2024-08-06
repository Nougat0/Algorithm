package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main1252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] num1 = st.nextToken().toCharArray();
        char[] num2 = st.nextToken().toCharArray();
        int num1Max = num1.length-1, num2Max = num2.length-1;
        int maxIndex = Math.max(num1Max, num2Max);
        StringBuilder sb = new StringBuilder();
        //이진수 덧셈
        boolean plus = false; //올림 여부
        for(int i=0; i<=maxIndex; i++) {
            int value = plus ? 1 : 0;
            plus = false; //재설정
            //자릿수별 값 입력
            if(num1Max - i >= 0)
                value += Character.getNumericValue(num1[num1Max - i]);
            if(num2Max - i >= 0)
                value += Character.getNumericValue(num2[num2Max - i]);
            //최종 값 확인 및 다음 자리로 남는 값 올리기
            if(value > 1) { //값이 2 이상
                value -= 2;
                plus = true;
            }
            sb.insert(0, value);
        }
        if(plus) sb.insert(0, 1); //마지막 올림 확인
        //출력 - 왼쪽에 있는 중복된 leading zero 들 제거 (우측 끝자리가 아닐 경우에만)
        bw.write(String.valueOf(sb).replaceAll("^0+(?!$)", "") + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
