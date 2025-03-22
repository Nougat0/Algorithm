package baekjoon.resolved;

import java.io.*;
import java.util.*;

public class Main5565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int totalPrice = Integer.parseInt(br.readLine());
        for(int i=0; i<9; i++) totalPrice -= Integer.parseInt(br.readLine());
        bw.write(totalPrice + "\n"); //최종 남는 가격 출력
        bw.flush();
        bw.close();
        br.close();
    }
}
