package baekjoon.resolved;

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Main2896 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        //주스의 양
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        //비율
        st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        //연산
        if(!(a == b && b == c)) { //주스의 양이 같을 때의 비율 연산 필요
            int lcm = getLCM(getLCM(a, b), c); //순차 연산
            i *= lcm/a;
            j *= lcm/b;
            k *= lcm/c;
        }
        double max = Math.max(Math.max(i, j), k);
        double a_leftover = (1 - i/max) * a;
        double b_leftover = (1 - j/max) * b;
        double c_leftover = (1 - k/max) * c;
        DecimalFormat df = new DecimalFormat("###.######");
        sb.append(df.format(a_leftover)).append(' ').append(df.format(b_leftover)).append(' ').append(df.format(c_leftover));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


    /**
     * 최소공배수 구하기
     * @param x 숫자1
     * @param y 숫자2
     * @return 숫자1과 숫자2의 최소공배수
     */
    public static int getLCM(int x, int y) {
        int gcd = getGCD(x, y);
        return x * y / gcd;
    }

    /**
     * 최대공약수 구하기
     * @param x 숫자1
     * @param y 숫자2
     * @return 숫자1과 숫자2의 최대공약수
     */
    public static int getGCD(int x, int y) {
        int remainder;
        while(x % y != 0) {
            remainder = x % y;
            x = y;
            y = remainder;
        }
        return y;
    }
}
