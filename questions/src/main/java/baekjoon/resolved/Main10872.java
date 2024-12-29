package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력
        int number = Integer.parseInt(br.readLine());
        //팩토리얼 계산 및 출력
        if(number == 0) bw.write(1 + "\n");
        else {
            int result = 1;
            for(int i=1; i<=number; i++) {
                result *= i;
            }
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
