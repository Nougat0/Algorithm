package baekjoon.resolved;

import java.io.*;
public class Main6919 {
    /*
        https://www.acmicpc.net/problem/6919
        https://www.acmicpc.net/user/bcdlife
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int numer = Integer.parseInt(br.readLine()); //분자
        int denom = Integer.parseInt(br.readLine()); //분모
        int share = numer / denom; //몫
        int remain = numer % denom; //나머지
        //분기처리
        if(remain == 0) sb.append(share);
        else {
            if(share >= 1) sb.append(share).append(' ');
            //최대공약수로 나누기
            int GCD = getGCD(remain, denom);
            sb.append(remain / GCD).append('/').append(denom / GCD);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    /**
     * 최대공약수 구하기
     * @param a
     * @param b
     * @return a와 b의 최대공약수
     */
    public static int getGCD(int a, int b) {
        int remainder;
        while((remainder = a % b) != 0) {
            a = b;
            b = remainder;
        }
        return b;
    }
}
