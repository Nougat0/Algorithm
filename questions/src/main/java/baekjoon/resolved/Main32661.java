package baekjoon.resolved;

import java.io.*;

public class Main32661 {
    /*
        https://www.acmicpc.net/problem/32661
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int min = 100_001;
        int max = 9;
        int value, payment;
        while(n-- > 0) {
            value = Integer.parseInt(br.readLine());
            if(value < min) min = value;
            if(value > max) max = value;
        }
        if(max/2 >= min) payment = 0;
        else payment = min - max/2;
        bw.write(payment + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
