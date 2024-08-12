package baekjoon.processing;

import java.io.*;

public class Main2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] count = new int[10];
        //입력
        int result = 1;
        for(int i=0; i<3; i++)
            result *= Integer.parseInt(br.readLine());
        //각 자릿수별로 쓰인 숫자 세기
        while(result / 10 > 0) {
            count[result % 10]++;
            result /= 10;
        }
        count[result % 10]++; //1의 자릿수
        //출력
        for(int i=0; i<10; i++)
            bw.write(count[i] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
