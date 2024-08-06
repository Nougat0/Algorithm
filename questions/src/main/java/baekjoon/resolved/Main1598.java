package baekjoon.resolved;

import java.io.*;
import java.util.StringTokenizer;

public class Main1598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 11/4 = 2, 11%4 = 3

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

//        int num1x = num1 % 4 == 0 ? 3 : num1 % 4 - 1;
//        int num1y = num1 % 4 == 0 ? num1 / 4 - 1 : num1 / 4;
//        int num2x = num2 % 4 == 0 ? 3 : num2 % 4 - 1;
//        int num2y = num2 % 4 == 0 ? num1 / 4 - 1 : num2 / 4;

        bw.write(Math.abs(getX(num1) - getX(num2)) + Math.abs(getY(num1) - getY(num2)) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getX(int number) {
        if(number % 4 == 0) return 3;
        else return number % 4 - 1;
    }

    public static int getY(int number) {
        if(number % 4 == 0) return number / 4 - 1;
        else return number / 4;
    }
}
